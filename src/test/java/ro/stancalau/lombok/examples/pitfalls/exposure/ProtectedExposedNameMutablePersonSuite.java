package ro.stancalau.lombok.examples.pitfalls.exposure;

import com.github.peterwippermann.junit4.parameterizedsuite.ParameterizedSuite;
import org.junit.runner.RunWith;
import ro.stancalau.lombok.tests.FieldVisibilityTests;
import ro.stancalau.lombok.tests.person.PersonConstructorAndGetterTests;
import ro.stancalau.lombok.tests.person.PersonSetterTests;

import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;
import static org.junit.runners.Suite.SuiteClasses;

@RunWith(ParameterizedSuite.class)
@SuiteClasses({
        FieldVisibilityTests.class,
        PersonConstructorAndGetterTests.class,
        PersonSetterTests.class
})
public class ProtectedExposedNameMutablePersonSuite {

    private static final Class CLASS_UNDER_TEST = ProtectedExposedNameMutablePerson.class;

    @Parameters(name = "Class under test is {0}")
    public static Object[] params() {
        return new Object[][]{{CLASS_UNDER_TEST}};
    }

    @Parameter
    public Class clazz;
}
