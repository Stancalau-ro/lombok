package ro.stancalau.lombok.api;

import org.junit.Before;
import org.junit.Test;
import ro.stancalau.lombok.goodpractice.CorrectMutablePerson;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public abstract class MutablePersonTest implements PersonFactory {

    private static final String NAME = "Joe";
    private static final String NEW_NAME = "Jerome";
    private static final String BOY_NAME = "Joel";
    private static final String GIRL_NAME = "Jane";
    private static final Person ILLEGITIMATE_CHILD = new CorrectMutablePerson("Bob");

    private Set<Person> globalChildren;

    @Before
    public void setUp() throws Exception {
        globalChildren = new HashSet<>();
        globalChildren.add(new CorrectMutablePerson(BOY_NAME));
        globalChildren.add(new CorrectMutablePerson(GIRL_NAME));
    }

    @Test
    public void givenValuesWhenConstructingPersonThenGettersReturnOriginalValues() throws Exception {
        //when
        Person joe = createPerson(NAME, globalChildren);

        //then
        assertEquals(NAME, joe.getName());
        assertEquals(2, joe.getChildren().size());
        assertEquals(globalChildren, joe.getChildren());
    }

    @Test
    public void givenPersonWhenMutatingChildListAsSideEffectThenPersonStateDoesNotChange() throws Exception {
        //given
        Person joe = createPerson(NAME, globalChildren);

        //when
        joe.getChildren().add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, joe.getChildren().size());
        assertEquals(globalChildren, joe.getChildren());
    }

    @Test
    public void givenPersonWhenMutatingChildListAsSideEffectThenGlobalSetDoesNotChange() throws Exception {
        //given
        Person joe = createPerson(NAME, globalChildren);

        //when
        joe.getChildren().add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, globalChildren.size());
    }

    @Test
    public void givenPersonWhenMutatingGlobalSetThenPersonChildrenDoNotChange() throws Exception {
        //given
        Person joe = createPerson(NAME, globalChildren);

        //when
        globalChildren.add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, joe.getChildren().size());
    }

    @Test
    public void givenPersonWhenAddingChildThenChildCountIncreases() throws Exception {
        //given
        Person joe = createPerson(NAME, globalChildren);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(3, joe.getChildren().size());
    }

    @Test
    public void givenPersonWhenAddingChildThenNewChildIsContainedInChildren() throws Exception {
        //given
        Person joe = createPerson(NAME, globalChildren);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertTrue(joe.getChildren().contains(ILLEGITIMATE_CHILD));
    }

    @Test
    public void givenPersonWhenAddingChildThenGlobalSetSizeDoesNotChange() throws Exception {
        //given
        Person joe = createPerson(NAME, globalChildren);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, globalChildren.size());
    }

    @Test
    public void givenPersonWhenAddingChildThenNewChildNotContainedInGlobalSet() throws Exception {
        //given
        Person joe = createPerson(NAME, globalChildren);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertFalse(globalChildren.contains(ILLEGITIMATE_CHILD));
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
        createPerson(name, globalChildren);
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

    @Test
    public void givenPersonWhenSetNameThenGetUpdatedName() throws Exception {
        //given
        Person joe = createPerson(NAME);

        //when
        joe.setName(NEW_NAME);

        //then
        assertEquals(NEW_NAME, joe.getName());
    }

    @Test
    public void givenPersonWhenSetChildrenThenGetUpdatedChildrenSet() throws Exception {
        //given
        Person joe = createPerson(NAME, globalChildren);

        //when
        Set<Person> newChildren = Collections.singleton(createPerson(NEW_NAME));
        joe.setChildren(newChildren);

        //then
        assertEquals(newChildren, joe.getChildren());
    }

    @Test
    public void givenPersonWithSetChildrenWhenOriginalSetChangesThenPersonChildrenDoNotChange() throws Exception {
        //given
        Person joe = createPerson(NAME);
        Set<Person> newChildren = new HashSet<>();
        joe.setChildren(newChildren);
        int childCount = newChildren.size();

        //when
        newChildren.add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(childCount, joe.getChildren().size());
        assertFalse(joe.getChildren().contains(ILLEGITIMATE_CHILD));
    }

    @Test
    public void givenPersonWithSetChildrenWhenPersonChildAddedThenOriginalSetNotChanged() throws Exception {
        //given
        Person joe = createPerson(NAME);
        Set<Person> newChildren = new HashSet<>();
        joe.setChildren(newChildren);
        int childCount = newChildren.size();

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(childCount, newChildren.size());
        assertFalse(newChildren.contains(ILLEGITIMATE_CHILD));
    }
}
