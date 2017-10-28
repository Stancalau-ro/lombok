package ro.stancalau.lombok.tests.base;

import com.github.peterwippermann.junit4.parameterizedsuite.ParameterContext;
import org.junit.Before;
import org.junit.runners.Parameterized;
import ro.stancalau.lombok.api.ImmutableParent;
import ro.stancalau.lombok.api.MutablePerson;
import ro.stancalau.lombok.examples.acceptable.MutableParentImpl;
import ro.stancalau.lombok.factory.ParentReflectionFactory;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static ro.stancalau.lombok.tests.base.TestNames.BOY_NAME;
import static ro.stancalau.lombok.tests.base.TestNames.GIRL_NAME;

public abstract class ParentBaseTest<T extends ImmutableParent> extends ParentReflectionFactory<T> {

    //TODO refactor this to a common class for this and PersonBaseTest
    @Parameterized.Parameters(name = "Class is {0}")
    public static Iterable<Object[]> params() {
        if (ParameterContext.isParameterSet()) {
            return Collections.singletonList(ParameterContext.getParameter(Object[].class));
        } else {
            throw new AssertionError("No class parameter for execution");
        }
    }

    protected static final MutablePerson ILLEGITIMATE_CHILD = new MutableParentImpl("Bob");

    protected Set<MutablePerson> globalChildren;

    @Before
    public void setUpChildren() throws Exception {
        globalChildren = new HashSet<>();
        globalChildren.add(new MutableParentImpl(BOY_NAME));
        globalChildren.add(new MutableParentImpl(GIRL_NAME));
    }

    public ParentBaseTest(Class<T> clazz) {
        super(clazz);
    }
}
