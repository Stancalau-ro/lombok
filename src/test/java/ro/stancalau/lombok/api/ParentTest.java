package ro.stancalau.lombok.api;

import org.junit.Before;
import org.junit.Test;
import ro.stancalau.lombok.goodpractice.CorrectParent;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public abstract class ParentTest extends PersonTest<Parent> implements ParentFactory<Parent> {

    private static final String BOY_NAME = "Joel";
    private static final String GIRL_NAME = "Jane";
    private static final Person ILLEGITIMATE_CHILD = new CorrectParent("Bob");

    private Set<Person> globalChildren;

    @Before
    public void setUp() throws Exception {
        globalChildren = new HashSet<>();
        globalChildren.add(new CorrectParent(BOY_NAME));
        globalChildren.add(new CorrectParent(GIRL_NAME));
    }

    @Test
    public void givenValuesWhenConstructingParentThenGettersReturnOriginalValues() throws Exception {
        //when
        Parent joe = createPerson(NAME, globalChildren);

        //then
        assertEquals(NAME, joe.getName());
        assertEquals(2, joe.getChildren().size());
        assertEquals(globalChildren, joe.getChildren());
    }

    @Test
    public void givenParentWhenMutatingChildListAsSideEffectThenParentStateDoesNotChange() throws Exception {
        //given
        Parent joe = createPerson(NAME, globalChildren);

        //when
        joe.getChildren().add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, joe.getChildren().size());
        assertEquals(globalChildren, joe.getChildren());
    }

    @Test
    public void givenParentWhenMutatingChildListAsSideEffectThenGlobalSetDoesNotChange() throws Exception {
        //given
        Parent joe = createPerson(NAME, globalChildren);

        //when
        joe.getChildren().add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, globalChildren.size());
    }

    @Test
    public void givenParentWhenMutatingGlobalSetThenParentChildrenDoNotChange() throws Exception {
        //given
        Parent joe = createPerson(NAME, globalChildren);

        //when
        globalChildren.add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, joe.getChildren().size());
    }

    @Test
    public void givenParentWhenAddingChildThenChildCountIncreases() throws Exception {
        //given
        Parent joe = createPerson(NAME, globalChildren);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(3, joe.getChildren().size());
    }

    @Test
    public void givenParentWhenAddingChildThenNewChildIsContainedInChildren() throws Exception {
        //given
        Parent joe = createPerson(NAME, globalChildren);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertTrue(joe.getChildren().contains(ILLEGITIMATE_CHILD));
    }

    @Test
    public void givenParentWhenAddingChildThenGlobalSetSizeDoesNotChange() throws Exception {
        //given
        Parent joe = createPerson(NAME, globalChildren);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, globalChildren.size());
    }

    @Test
    public void givenParentWhenAddingChildThenNewChildNotContainedInGlobalSet() throws Exception {
        //given
        Parent joe = createPerson(NAME, globalChildren);

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
        Parent joe = createPerson(NAME);

        //then
        assertEquals(0, joe.getChildren().size());
    }

    @Test
    public void givenParentConstructedByNameWhenAddChildThenChildCountIncreases() throws Exception {
        //given
        Parent joe = createPerson(NAME);

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(1, joe.getChildren().size());
    }

    @Test
    public void givenNoParamsWhenConstructThenChildrenSetSizeIsZero() throws Exception {
        //when
        Parent joe = createPerson();

        //then
        assertEquals(0, joe.getChildren().size());
    }

    @Test
    public void givenParentConstructedWithNoArgsWhenAddChildThenChildCountIncreases() throws Exception {
        //given
        Parent joe = createPerson();

        //when
        joe.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(1, joe.getChildren().size());
    }

    @Test
    public void givenParentWhenSetChildrenThenGetUpdatedChildrenSet() throws Exception {
        //given
        Parent joe = createPerson(NAME, globalChildren);

        //when
        Set<Person> newChildren = Collections.singleton(createPerson(NEW_NAME));
        joe.setChildren(newChildren);

        //then
        assertEquals(newChildren, joe.getChildren());
    }

    @Test
    public void givenParentWithSetChildrenWhenOriginalSetChangesThenParentChildrenDoNotChange() throws Exception {
        //given
        Parent joe = createPerson(NAME);
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
    public void givenParentWithSetChildrenWhenParentChildAddedThenOriginalSetNotChanged() throws Exception {
        //given
        Parent joe = createPerson(NAME);
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
