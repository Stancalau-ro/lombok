package ro.stancalau.lombok.tests.person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ro.stancalau.lombok.api.ImmutableParent;
import ro.stancalau.lombok.api.ImmutablePerson;
import ro.stancalau.lombok.factory.PersonFactory;
import ro.stancalau.lombok.factory.PersonReflectionFactory;
import ro.stancalau.lombok.tests.base.EqualableTestParam;
import ro.stancalau.lombok.tests.base.PersonBaseTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ExtendedEqualsSymmetryTest<P extends ImmutablePerson, C extends ImmutableParent> extends PersonBaseTest<P> {

    private final Class<C> childClass;
    private PersonFactory<C> childFactory;

    public ExtendedEqualsSymmetryTest(EqualableTestParam param) {
        super((Class<P>) param.getClassUnderTest());
        childClass = (Class<C>) param.getChildClass();
        assertTrue("Child class does not appear to extend parent class.", param.getClassUnderTest().isAssignableFrom(childClass));
        childFactory = new PersonReflectionFactory<>(childClass);
    }

    @Test
    public void givenSameStateChildAndParentWhenEqualsThenFalseIsSymmetricalFromParentToChild() throws Exception {
        ImmutablePerson parent = create();
        ImmutableParent child = childFactory.create();

        assertFalse(parent.equals(child));
    }

    @Test
    public void givenSameStateChildAndParentWhenEqualsThenFalseIsSymmetricalFromChildToParent() throws Exception {
        ImmutablePerson parent = create();
        ImmutableParent child = childFactory.create();

        assertFalse(child.equals(parent));
    }
}
