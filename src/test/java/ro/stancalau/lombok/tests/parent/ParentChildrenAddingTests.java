package ro.stancalau.lombok.tests.parent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ro.stancalau.lombok.api.MutableParent;
import ro.stancalau.lombok.tests.base.ParentBaseTest;

import static org.junit.Assert.*;
import static ro.stancalau.lombok.tests.base.TestNames.NAME;

@RunWith(Parameterized.class)
public class ParentChildrenAddingTests extends ParentBaseTest<MutableParent> {

    public ParentChildrenAddingTests(Class<? extends MutableParent> clazz) {
        super((Class<MutableParent>) clazz);
    }

    @Test
    public void givenParentWhenAddingChildThenChildCountIncreases() throws Exception {
        //given
        MutableParent mutableParent = create(NAME, globalChildren);

        //when
        mutableParent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(3, mutableParent.getChildren().size());
    }

    @Test
    public void givenParentWhenAddingChildThenNewChildIsContainedInChildren() throws Exception {
        //given
        MutableParent mutableParent = create(NAME, globalChildren);

        //when
        mutableParent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertTrue(mutableParent.getChildren().contains(ILLEGITIMATE_CHILD));
    }

    @Test
    public void givenParentWhenAddingChildThenGlobalSetSizeDoesNotChange() throws Exception {
        //given
        MutableParent mutableParent = create(NAME, globalChildren);

        //when
        mutableParent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, globalChildren.size());
    }

    @Test
    public void givenParentWhenAddingChildThenNewChildNotContainedInGlobalSet() throws Exception {
        //given
        MutableParent mutableParent = create(NAME, globalChildren);

        //when
        mutableParent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertFalse(globalChildren.contains(ILLEGITIMATE_CHILD));
    }

    @Test
    public void givenParentConstructedByNameWhenAddChildThenChildCountIncreases() throws Exception {
        //given
        MutableParent mutableParent = create(NAME);

        //when
        mutableParent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(1, mutableParent.getChildren().size());
    }

    @Test
    public void givenParentConstructedWithNoArgsWhenAddChildThenChildCountIncreases() throws Exception {
        //given
        MutableParent mutableParent = create();

        //when
        mutableParent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(1, mutableParent.getChildren().size());
    }
}
