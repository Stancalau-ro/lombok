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
    public void givenValuesWhenConstructingHumanThenGettersReturnOriginalValues() throws Exception {
        //when
        Person joe = createHuman(NAME, globalMutableChildren);

        //then
        assertEquals(NAME, joe.getName());
        assertEquals(2, joe.getChildren().size());
        assertEquals(globalMutableChildren, joe.getChildren());
    }

    @Test
    public void givenHumanWhenMutatingChildListAsSideEffectThenHumanStateDoesNotChange() throws Exception {
        //given
        Person joe = createHuman(NAME, globalMutableChildren);

        //when
        joe.getChildren().add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, joe.getChildren().size());
        assertEquals(globalMutableChildren, joe.getChildren());
    }

    @Test
    public void givenHumanWhenMutatingChildListAsSideEffectThenGlobalSetDoesNotChange() throws Exception {
        //given
        Person joe = createHuman(NAME, globalMutableChildren);

        //when
        joe.getChildren().add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, globalMutableChildren.size());
    }

    @Test
    public void givenHumanWhenMutatingGlobalSetThenHumanChildrenDoNotChange() throws Exception {
        //given
        Person joe = createHuman(NAME, globalMutableChildren);

        //when
        globalMutableChildren.add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, joe.getChildren().size());
    }

    @Test
    public void givenHumanWhenAddingChildThenChildCountIncreases() throws Exception {
        //given
        Person joe = createHuman(NAME, globalMutableChildren);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(3, joe.getChildren().size());
    }

    @Test
    public void givenHumanWhenAddingChildThenNewChildIsContainedInChildren() throws Exception {
        //given
        Person joe = createHuman(NAME, globalMutableChildren);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertTrue(joe.getChildren().contains(ILLEGITIMATE_CHILD));
    }

    @Test
    public void givenHumanWhenAddingChildThenGlobalSetSizeDoesNotChange() throws Exception {
        //given
        Person joe = createHuman(NAME, globalMutableChildren);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, globalMutableChildren.size());
    }

    @Test
    public void givenHumanWhenAddingChildThenNewChildNotContainedInGlobalSet() throws Exception {
        //given
        Person joe = createHuman(NAME, globalMutableChildren);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertFalse(globalMutableChildren.contains(ILLEGITIMATE_CHILD));
    }

    @Test(expected = NullPointerException.class)
    public void givenNullChildrenSetWhenConstructThenNullPointerExceptionExpected() throws Exception {
        //given
        Set<Person> children = null;

        //when
        createHuman(NAME, children);
    }

    @Test
    public void givenOnlyNameWhenConstructThenChildrenSetSizeIsZero() throws Exception {
        //when
        Person joe = createHuman(NAME);

        //then
        assertEquals(0, joe.getChildren().size());
    }

    @Test
    public void givenHumanConstructedByNameWhenAddChildThenChildCountIncreases() throws Exception {
        //given
        Person joe = createHuman(NAME);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(1, joe.getChildren().size());
    }

    protected abstract Person createHuman(String name, Set<Person> children);

    protected abstract Person createHuman(String name);
}
