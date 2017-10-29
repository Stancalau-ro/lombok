package ro.stancalau.lombok.tests.parent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ro.stancalau.lombok.api.ImmutableParent;
import ro.stancalau.lombok.tests.base.ParentBaseTest;
import ro.stancalau.lombok.tests.base.TestParam;

import static org.junit.Assert.assertEquals;
import static ro.stancalau.lombok.tests.base.TestNames.NAME;

@RunWith(Parameterized.class)
public class ParentChildrenGetterTests<T extends ImmutableParent> extends ParentBaseTest<T> {

    @SuppressWarnings("unchecked")
    public ParentChildrenGetterTests(TestParam param) {
        super((Class<T>) param.getClassUnderTest());
    }

    @Test
    public void givenParentWhenMutatingChildListAsSideEffectThenParentStateDoesNotChange() throws Exception {
        //given
        ImmutableParent mutableParent = create(NAME, globalChildren);

        //when
        mutableParent.getChildren().add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, mutableParent.getChildren().size());
        assertEquals(globalChildren, mutableParent.getChildren());
    }

    @Test
    public void givenParentWhenMutatingChildListAsSideEffectThenGlobalSetDoesNotChange() throws Exception {
        //given
        ImmutableParent mutableParent = create(NAME, globalChildren);

        //when
        mutableParent.getChildren().add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, globalChildren.size());
    }
}
