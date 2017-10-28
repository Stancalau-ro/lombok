package ro.stancalau.lombok.base.parent;

import org.junit.Test;
import ro.stancalau.lombok.api.MutableParent;
import ro.stancalau.lombok.factory.ParentCreator;

import static org.junit.Assert.*;

public abstract class ParentChildrenAddingTests<T extends MutableParent> extends ParentCreator<T> {

    public ParentChildrenAddingTests(Class<T> clazz) {
        super(clazz);
    }

    @Test
    public void givenParentWhenAddingChildThenChildCountIncreases() throws Exception {
        //given
        T mutableParent = create(NAME, globalChildren);

        //when
        mutableParent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(3, mutableParent.getChildren().size());
    }

    @Test
    public void givenParentWhenAddingChildThenNewChildIsContainedInChildren() throws Exception {
        //given
        T mutableParent = create(NAME, globalChildren);

        //when
        mutableParent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertTrue(mutableParent.getChildren().contains(ILLEGITIMATE_CHILD));
    }

    @Test
    public void givenParentWhenAddingChildThenGlobalSetSizeDoesNotChange() throws Exception {
        //given
        T mutableParent = create(NAME, globalChildren);

        //when
        mutableParent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, globalChildren.size());
    }

    @Test
    public void givenParentWhenAddingChildThenNewChildNotContainedInGlobalSet() throws Exception {
        //given
        T mutableParent = create(NAME, globalChildren);

        //when
        mutableParent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertFalse(globalChildren.contains(ILLEGITIMATE_CHILD));
    }

    @Test
    public void givenParentConstructedByNameWhenAddChildThenChildCountIncreases() throws Exception {
        //given
        T mutableParent = create(NAME);

        //when
        mutableParent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(1, mutableParent.getChildren().size());
    }

    @Test
    public void givenParentConstructedWithNoArgsWhenAddChildThenChildCountIncreases() throws Exception {
        //given
        T mutableParent = create();

        //when
        mutableParent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(1, mutableParent.getChildren().size());
    }
}
