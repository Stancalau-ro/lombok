package ro.stancalau.lombok.tests.base;

import com.github.peterwippermann.junit4.parameterizedsuite.ParameterContext;

import java.util.Collections;

import static org.junit.runners.Parameterized.Parameters;

public class ParameterizedTest {

    @Parameters(name = "Class is {0}")
    public static Iterable<Object[]> params() {
        if (ParameterContext.isParameterSet()) {
            return Collections.singletonList(ParameterContext.getParameter(Object[].class));
        } else {
            throw new AssertionError("No class parameter for execution");
        }
    }
}
