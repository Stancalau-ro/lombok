package ro.stancalau.lombok.examples.acceptable.immutable;

import com.github.peterwippermann.junit4.parameterizedsuite.ParameterizedSuite;
import org.junit.runner.RunWith;
import ro.stancalau.lombok.examples.acceptable.ImmutableParentImpl;
import ro.stancalau.lombok.tests.FieldVisibilityTests;
import ro.stancalau.lombok.tests.parent.ParentChildrenGetterTests;
import ro.stancalau.lombok.tests.parent.ParentConstructorTests;
import ro.stancalau.lombok.tests.person.PersonBaseEqualsAndHashTests;
import ro.stancalau.lombok.tests.person.PersonConstructorAndGetterTests;

import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;
import static org.junit.runners.Suite.SuiteClasses;

@RunWith(ParameterizedSuite.class)
@SuiteClasses({
        FieldVisibilityTests.class,
        ParentChildrenGetterTests.class,
        ParentConstructorTests.class,
        PersonBaseEqualsAndHashTests.class,
        PersonConstructorAndGetterTests.class
})
public class ImutableParentImplSuite {

    @Parameters(name = "Class under test is {0}")
    public static Object[] params() {
        return new Object[][]{{ImmutableParentImpl.class}};
    }

    @Parameter(0)
    public Class clazz;

}
