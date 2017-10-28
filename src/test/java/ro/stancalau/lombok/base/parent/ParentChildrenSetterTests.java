package ro.stancalau.lombok.base.parent;

import org.junit.Test;
import ro.stancalau.lombok.api.MutableParent;
import ro.stancalau.lombok.api.MutablePerson;
import ro.stancalau.lombok.factory.ParentCreator;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public abstract class ParentChildrenSetterTests<T extends MutableParent> extends ParentCreator<T> {

    public ParentChildrenSetterTests(Class<T> clazz) {
        super(clazz);
    }

    @Test
    public void givenParentWhenSetChildrenThenGetUpdatedChildrenSet() throws Exception {
        //given
        T mutableParent = create(NAME, globalChildren);

        //when
        Set<MutablePerson> newChildren = Collections.singleton(create(NEW_NAME));
        mutableParent.setChildren(newChildren);

        //then
        assertEquals(newChildren, mutableParent.getChildren());
    }

    @Test
    public void givenParentWithSetChildrenWhenOriginalSetChangesThenParentChildrenDoNotChange() throws Exception {
        //given
        T mutableParent = create(NAME);
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
        T mutableParent = create(NAME);
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
