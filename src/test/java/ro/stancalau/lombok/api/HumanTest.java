package ro.stancalau.lombok.api;

import org.junit.Before;
import org.junit.Test;
import ro.stancalau.lombok.goodpractice.CorrectHuman;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public abstract class HumanTest {

    protected static final String NAME = "Joe";
    private static final String BOY_NAME = "Joel";
    private static final String GIRL_NAME = "Jane";

    protected Set<Human> globalMutableChildren;
    private static final Human ILLEGITIMATE_CHILD = new CorrectHuman("Bob");

    @Before
    public void setUp() throws Exception {
        globalMutableChildren = new HashSet<>();
        globalMutableChildren.add(new CorrectHuman(BOY_NAME));
        globalMutableChildren.add(new CorrectHuman(GIRL_NAME));
    }

    @Test
    public void givenValuesWhenConstructingHumanThenGettersReturnOriginalValues() throws Exception {
        //when
        Human joe = createHuman(NAME, globalMutableChildren);

        //then
        assertEquals(NAME, joe.getName());
        assertEquals(2, joe.getChildren().size());
        assertEquals(globalMutableChildren, joe.getChildren());
    }

    @Test
    public void givenHumanWhenMutatingChildListAsSideEffectThenHumanStateDoesNotChange() throws Exception {
        //given
        Human joe = createHuman(NAME, globalMutableChildren);

        //when
        joe.getChildren().add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, joe.getChildren().size());
        assertEquals(globalMutableChildren, joe.getChildren());
    }

    @Test
    public void givenHumanWhenMutatingChildListAsSideEffectThenGlobalSetDoesNotChange() throws Exception {
        //given
        Human joe = createHuman(NAME, globalMutableChildren);

        //when
        joe.getChildren().add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, globalMutableChildren.size());
    }

    @Test
    public void givenHumanWhenMutatingGlobalSetThenHumanChildrenDoNotChange() throws Exception {
        //given
        Human joe = createHuman(NAME, globalMutableChildren);

        //when
        globalMutableChildren.add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, joe.getChildren().size());
    }

    @Test
    public void givenHumanWhenAddingChildThenChildCountIncreases() throws Exception {
        //given
        Human joe = createHuman(NAME, globalMutableChildren);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(3, joe.getChildren().size());
    }

    @Test
    public void givenHumanWhenAddingChildThenNewChildIsContainedInChildren() throws Exception {
        //given
        Human joe = createHuman(NAME, globalMutableChildren);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertTrue(joe.getChildren().contains(ILLEGITIMATE_CHILD));
    }

    @Test
    public void givenHumanWhenAddingChildThenGlobalSetSizeDoesNotChange() throws Exception {
        //given
        Human joe = createHuman(NAME, globalMutableChildren);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, globalMutableChildren.size());
    }

    @Test
    public void givenHumanWhenAddingChildThenNewChildNotContainedInGlobalSet() throws Exception {
        //given
        Human joe = createHuman(NAME, globalMutableChildren);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertFalse(globalMutableChildren.contains(ILLEGITIMATE_CHILD));
    }

    @Test(expected = NullPointerException.class)
    public void givenNullChildrenSetWhenConstructThenNullPointerExceptionExpected() throws Exception {
        //given
        Set<Human> children = null;

        //when
        Human joe = createHuman(NAME, children);
    }

    @Test
    public void givenOnlyNameWhenConstructThenChildrenSetSizeIsZero() throws Exception {
        //when
        Human joe = createHuman(NAME);

        //then
        assertEquals(0, joe.getChildren().size());
    }

    @Test
    public void givenHumanConstructedByNameWhenAddChildThenChildCountIncreases() throws Exception {
        //given
        Human joe = createHuman(NAME);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(1, joe.getChildren().size());
    }

    protected abstract Human createHuman(String name, Set<Human> children);

    protected abstract Human createHuman(String name);
}
