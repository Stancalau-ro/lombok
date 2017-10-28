package ro.stancalau.lombok.tests.base;

import com.github.peterwippermann.junit4.parameterizedsuite.ParameterContext;
import org.junit.runners.Parameterized;
import ro.stancalau.lombok.api.ImmutablePerson;
import ro.stancalau.lombok.factory.PersonReflectionFactory;

import java.util.Collections;

public abstract class PersonBaseTest<T extends ImmutablePerson> extends PersonReflectionFactory<T> {

    @Parameterized.Parameters(name = "Class is {0}")
    public static Iterable<Object[]> params() {
        if (ParameterContext.isParameterSet()) {
            return Collections.singletonList(ParameterContext.getParameter(Object[].class));
        } else {
            throw new AssertionError("No class parameter for execution");
        }
    }

    public PersonBaseTest(Class<T> clazz) {
        super(clazz);
    }
}
