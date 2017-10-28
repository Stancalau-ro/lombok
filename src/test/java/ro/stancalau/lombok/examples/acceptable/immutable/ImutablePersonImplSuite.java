package ro.stancalau.lombok.examples.acceptable.immutable;

import com.github.peterwippermann.junit4.parameterizedsuite.ParameterizedSuite;
import org.junit.runner.RunWith;
import ro.stancalau.lombok.examples.acceptable.ImmutablePersonImpl;
import ro.stancalau.lombok.tests.FieldVisibilityTests;
import ro.stancalau.lombok.tests.person.PersonBaseEqualsAndHashTests;
import ro.stancalau.lombok.tests.person.PersonConstructorAndGetterTests;

import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;
import static org.junit.runners.Suite.SuiteClasses;

@RunWith(ParameterizedSuite.class)
@SuiteClasses({
        FieldVisibilityTests.class,
        PersonBaseEqualsAndHashTests.class,
        PersonConstructorAndGetterTests.class
})
public class ImutablePersonImplSuite {

    @Parameters(name = "Class under test is {0}")
    public static Object[] params() {
        return new Object[][]{{ImmutablePersonImpl.class}};
    }

    @Parameter(0)
    public Class clazz;

}
