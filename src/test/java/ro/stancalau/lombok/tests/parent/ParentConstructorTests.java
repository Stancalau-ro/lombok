package ro.stancalau.lombok.tests.parent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ro.stancalau.lombok.api.ImmutableParent;
import ro.stancalau.lombok.api.MutablePerson;
import ro.stancalau.lombok.tests.base.ParentBaseTest;
import ro.stancalau.lombok.tests.base.TestParam;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static ro.stancalau.lombok.tests.base.TestNames.NAME;

@RunWith(Parameterized.class)
public class ParentConstructorTests<T extends ImmutableParent> extends ParentBaseTest<T> {

    @SuppressWarnings("unchecked")
    public ParentConstructorTests(TestParam param) {
        super((Class<T>) param.getClassUnderTest());
    }

    @Test
    public void givenValuesWhenConstructingParentThenGettersReturnOriginalValues() throws Exception {
        //when
        ImmutableParent mutableParent = create(NAME, globalChildren);

        //then
        assertEquals(NAME, mutableParent.getName());
        assertEquals(2, mutableParent.getChildren().size());
        assertEquals(globalChildren, mutableParent.getChildren());
    }

    @Test
    public void givenParentWhenMutatingGlobalSetThenParentChildrenDoNotChange() throws Exception {
        //given
        ImmutableParent mutableParent = create(NAME, globalChildren);

        //when
        globalChildren.add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, mutableParent.getChildren().size());
    }

    @Test(expected = NullPointerException.class)
    public void givenNullChildrenSetWhenConstructingThenNullPointerExceptionExpected() throws Exception {
        //given
        Set<MutablePerson> children = null;

        //when
        create(NAME, children);
    }

    @Test(expected = NullPointerException.class)
    public void givenNullNameConstructingThenNullPointerExceptionExpected() throws Exception {
        //given
        String name = null;

        //when
        create(name, globalChildren);
    }

    @Test
    public void givenOnlyNameWhenConstructingThenChildrenSetSizeIsZero() throws Exception {
        //when
        ImmutableParent mutableParent = create(NAME);

        //then
        assertEquals(0, mutableParent.getChildren().size());
    }

    @Test
    public void givenNoParamsWhenConstructThenChildrenSetSizeIsZero() throws Exception {
        //when
        ImmutableParent mutableParent = create();

        //then
        assertEquals(0, mutableParent.getChildren().size());
    }
}
