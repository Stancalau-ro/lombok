package ro.stancalau.lombok.api;

import org.junit.Before;
import org.junit.Test;
import ro.stancalau.lombok.goodpractice.CorrectPerson;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public abstract class PersonTest {

    protected static final String NAME = "Joe";
    private static final String BOY_NAME = "Joel";
    private static final String GIRL_NAME = "Jane";

    protected Set<Person> globalMutableChildren;
    private static final Person ILLEGITIMATE_CHILD = new CorrectPerson("Bob");

    @Before
    public void setUp() throws Exception {
        globalMutableChildren = new HashSet<>();
        globalMutableChildren.add(new CorrectPerson(BOY_NAME));
        globalMutableChildren.add(new CorrectPerson(GIRL_NAME));
    }

    @Test
    public void givenValuesWhenConstructingPersonThenGettersReturnOriginalValues() throws Exception {
        //when
        Person joe = createPerson(NAME, globalMutableChildren);

        //then
        assertEquals(NAME, joe.getName());
        assertEquals(2, joe.getChildren().size());
        assertEquals(globalMutableChildren, joe.getChildren());
    }

    @Test
    public void givenPersonWhenMutatingChildListAsSideEffectThenPersonStateDoesNotChange() throws Exception {
        //given
        Person joe = createPerson(NAME, globalMutableChildren);

        //when
        joe.getChildren().add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, joe.getChildren().size());
        assertEquals(globalMutableChildren, joe.getChildren());
    }

    @Test
    public void givenPersonWhenMutatingChildListAsSideEffectThenGlobalSetDoesNotChange() throws Exception {
        //given
        Person joe = createPerson(NAME, globalMutableChildren);

        //when
        joe.getChildren().add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, globalMutableChildren.size());
    }

    @Test
    public void givenPersonWhenMutatingGlobalSetThenPersonChildrenDoNotChange() throws Exception {
        //given
        Person joe = createPerson(NAME, globalMutableChildren);

        //when
        globalMutableChildren.add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, joe.getChildren().size());
    }

    @Test
    public void givenPersonWhenAddingChildThenChildCountIncreases() throws Exception {
        //given
        Person joe = createPerson(NAME, globalMutableChildren);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(3, joe.getChildren().size());
    }

    @Test
    public void givenPersonWhenAddingChildThenNewChildIsContainedInChildren() throws Exception {
        //given
        Person joe = createPerson(NAME, globalMutableChildren);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertTrue(joe.getChildren().contains(ILLEGITIMATE_CHILD));
    }

    @Test
    public void givenPersonWhenAddingChildThenGlobalSetSizeDoesNotChange() throws Exception {
        //given
        Person joe = createPerson(NAME, globalMutableChildren);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, globalMutableChildren.size());
    }

    @Test
    public void givenPersonWhenAddingChildThenNewChildNotContainedInGlobalSet() throws Exception {
        //given
        Person joe = createPerson(NAME, globalMutableChildren);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertFalse(globalMutableChildren.contains(ILLEGITIMATE_CHILD));
    }

    @Test(expected = NullPointerException.class)
    public void givenNullChildrenSetWhenConstructingThenNullPointerExceptionExpected() throws Exception {
        //given
        Set<Person> children = null;

        //when
        createPerson(NAME, children);
    }

    @Test(expected = NullPointerException.class)
    public void givenNullNameConstructingThenNullPointerExceptionExpected() throws Exception {
        //given
        String name = null;

        //when
        createPerson(name, globalMutableChildren);
    }

    @Test
    public void givenOnlyNameWhenConstructingThenChildrenSetSizeIsZero() throws Exception {
        //when
        Person joe = createPerson(NAME);

        //then
        assertEquals(0, joe.getChildren().size());
    }

    @Test
    public void givenPersonConstructedByNameWhenAddChildThenChildCountIncreases() throws Exception {
        //given
        Person joe = createPerson(NAME);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(1, joe.getChildren().size());
    }

    @Test
    public void givenNoParamsWhenConstructThenChildrenSetSizeIsZero() throws Exception {
        //when
        Person joe = createPerson();

        //then
        assertEquals(0, joe.getChildren().size());
    }

    @Test
    public void givenPersonConstructedWithNoArgsWhenAddChildThenChildCountIncreases() throws Exception {
        //given
        Person joe = createPerson();

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(1, joe.getChildren().size());
    }

    @Test
    public void givenPersonConstructedWithNoArgsWhenGetNameThenItIsDefault() throws Exception {
        //given
        Person joe = createPerson();

        //when
        String name = joe.getName();

        //then
        assertEquals(Person.DEFAULT_NAME, name);
    }

    protected abstract Person createPerson(String name, Set<Person> children);

    protected abstract Person createPerson(String name);

    protected abstract Person createPerson();
}
