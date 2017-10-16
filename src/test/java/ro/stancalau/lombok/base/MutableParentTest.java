package ro.stancalau.lombok.base;

import org.junit.Before;
import org.junit.Test;
import ro.stancalau.lombok.api.MutableParent;
import ro.stancalau.lombok.api.MutablePerson;
import ro.stancalau.lombok.examples.acceptable.MutableParentImpl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public abstract class MutableParentTest extends MutablePersonTest<MutableParent> implements ParentFactory<MutableParent> {

    private static final String BOY_NAME = "Joel";
    private static final String GIRL_NAME = "Jane";
    private static final MutablePerson ILLEGITIMATE_CHILD = new MutableParentImpl("Bob");

    private Set<MutablePerson> globalChildren;

    @Before
    public void setUpChildren() throws Exception {
        globalChildren = new HashSet<>();
        globalChildren.add(new MutableParentImpl(BOY_NAME));
        globalChildren.add(new MutableParentImpl(GIRL_NAME));
    }

    @Test
    public void givenValuesWhenConstructingParentThenGettersReturnOriginalValues() throws Exception {
        //when
        MutableParent mutableParent = createPerson(NAME, globalChildren);

        //then
        assertEquals(NAME, mutableParent.getName());
        assertEquals(2, mutableParent.getChildren().size());
        assertEquals(globalChildren, mutableParent.getChildren());
    }

    @Test
    public void givenParentWhenMutatingChildListAsSideEffectThenParentStateDoesNotChange() throws Exception {
        //given
        MutableParent mutableParent = createPerson(NAME, globalChildren);

        //when
        mutableParent.getChildren().add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, mutableParent.getChildren().size());
        assertEquals(globalChildren, mutableParent.getChildren());
    }

    @Test
    public void givenParentWhenMutatingChildListAsSideEffectThenGlobalSetDoesNotChange() throws Exception {
        //given
        MutableParent mutableParent = createPerson(NAME, globalChildren);

        //when
        mutableParent.getChildren().add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, globalChildren.size());
    }

    @Test
    public void givenParentWhenMutatingGlobalSetThenParentChildrenDoNotChange() throws Exception {
        //given
        MutableParent mutableParent = createPerson(NAME, globalChildren);

        //when
        globalChildren.add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, mutableParent.getChildren().size());
    }

    @Test
    public void givenParentWhenAddingChildThenChildCountIncreases() throws Exception {
        //given
        MutableParent mutableParent = createPerson(NAME, globalChildren);

        //when
        mutableParent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(3, mutableParent.getChildren().size());
    }

    @Test
    public void givenParentWhenAddingChildThenNewChildIsContainedInChildren() throws Exception {
        //given
        MutableParent mutableParent = createPerson(NAME, globalChildren);

        //when
        mutableParent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertTrue(mutableParent.getChildren().contains(ILLEGITIMATE_CHILD));
    }

    @Test
    public void givenParentWhenAddingChildThenGlobalSetSizeDoesNotChange() throws Exception {
        //given
        MutableParent mutableParent = createPerson(NAME, globalChildren);

        //when
        mutableParent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, globalChildren.size());
    }

    @Test
    public void givenParentWhenAddingChildThenNewChildNotContainedInGlobalSet() throws Exception {
        //given
        MutableParent mutableParent = createPerson(NAME, globalChildren);

        //when
        mutableParent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertFalse(globalChildren.contains(ILLEGITIMATE_CHILD));
    }

    @Test(expected = NullPointerException.class)
    public void givenNullChildrenSetWhenConstructingThenNullPointerExceptionExpected() throws Exception {
        //given
        Set<MutablePerson> children = null;

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
        MutableParent mutableParent = createPerson(NAME);

        //then
        assertEquals(0, mutableParent.getChildren().size());
    }

    @Test
    public void givenParentConstructedByNameWhenAddChildThenChildCountIncreases() throws Exception {
        //given
        MutableParent mutableParent = createPerson(NAME);

        //when
        mutableParent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(1, mutableParent.getChildren().size());
    }

    @Test
    public void givenNoParamsWhenConstructThenChildrenSetSizeIsZero() throws Exception {
        //when
        MutableParent mutableParent = createPerson();

        //then
        assertEquals(0, mutableParent.getChildren().size());
    }

    @Test
    public void givenParentConstructedWithNoArgsWhenAddChildThenChildCountIncreases() throws Exception {
        //given
        MutableParent mutableParent = createPerson();

        //when
        mutableParent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(1, mutableParent.getChildren().size());
    }

    @Test
    public void givenParentWhenSetChildrenThenGetUpdatedChildrenSet() throws Exception {
        //given
        MutableParent mutableParent = createPerson(NAME, globalChildren);

        //when
        Set<MutablePerson> newChildren = Collections.singleton(createPerson(NEW_NAME));
        mutableParent.setChildren(newChildren);

        //then
        assertEquals(newChildren, mutableParent.getChildren());
    }

    @Test
    public void givenParentWithSetChildrenWhenOriginalSetChangesThenParentChildrenDoNotChange() throws Exception {
        //given
        MutableParent mutableParent = createPerson(NAME);
        Set<MutablePerson> newChildren = new HashSet<>();
        mutableParent.setChildren(newChildren);
        int childCount = newChildren.size();

        //when
        newChildren.add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(childCount, mutableParent.getChildren().size());
        assertFalse(mutableParent.getChildren().contains(ILLEGITIMATE_CHILD));
    }

    @Test
    public void givenParentWithSetChildrenWhenParentChildAddedThenOriginalSetNotChanged() throws Exception {
        //given
        MutableParent mutableParent = createPerson(NAME);
        Set<MutablePerson> newChildren = new HashSet<>();
        mutableParent.setChildren(newChildren);
        int childCount = newChildren.size();

        //when
        mutableParent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(childCount, newChildren.size());
        assertFalse(newChildren.contains(ILLEGITIMATE_CHILD));
    }
}
