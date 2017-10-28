package ro.stancalau.lombok.examples.correct;

import com.github.peterwippermann.junit4.parameterizedsuite.ParameterizedSuite;
import org.junit.runner.RunWith;
import ro.stancalau.lombok.tests.FieldVisibilityTests;
import ro.stancalau.lombok.tests.base.EqualableTestParam;
import ro.stancalau.lombok.tests.base.TestParam;
import ro.stancalau.lombok.tests.parent.ParentChildrenAddingTests;
import ro.stancalau.lombok.tests.parent.ParentChildrenGetterTests;
import ro.stancalau.lombok.tests.parent.ParentChildrenSetterTests;
import ro.stancalau.lombok.tests.parent.ParentConstructorTests;
import ro.stancalau.lombok.tests.person.ExtendedEqualsSymmetryTest;
import ro.stancalau.lombok.tests.person.MutableParentEqualsAndHashTests;
import ro.stancalau.lombok.tests.person.PersonConstructorAndGetterTests;
import ro.stancalau.lombok.tests.person.PersonSetterTests;

import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;
import static org.junit.runners.Suite.SuiteClasses;

@RunWith(ParameterizedSuite.class)
@SuiteClasses({
        FieldVisibilityTests.class,
        ParentChildrenAddingTests.class,
        ParentChildrenGetterTests.class,
        ParentChildrenSetterTests.class,
        ParentConstructorTests.class,
        PersonConstructorAndGetterTests.class,
        PersonSetterTests.class,
        ExtendedEqualsSymmetryTest.class,
        MutableParentEqualsAndHashTests.class
})
public class EqualableParentSuite {

    private static final Class CLASS_UNDER_TEST = EqualableParent.class;
    private static final Class CHILD_CLASS = ExtendedEqualableParent.class;

    @Parameters(name = "Class under test is {0}")
    public static Object[] params() {
        return new Object[][]{{new EqualableTestParam(CLASS_UNDER_TEST, CHILD_CLASS)}};
    }

    @Parameter
    public TestParam param;
}
