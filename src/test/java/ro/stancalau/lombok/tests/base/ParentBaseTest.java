package ro.stancalau.lombok.tests.base;

import org.junit.Before;
import ro.stancalau.lombok.api.ImmutableParent;
import ro.stancalau.lombok.api.MutablePerson;
import ro.stancalau.lombok.examples.acceptable.MutableParentImpl;
import ro.stancalau.lombok.factory.ParentReflectionFactory;

import java.util.HashSet;
import java.util.Set;

import static ro.stancalau.lombok.tests.base.TestNames.BOY_NAME;
import static ro.stancalau.lombok.tests.base.TestNames.GIRL_NAME;

public class ParentBaseTest<T extends ImmutableParent> extends ParentReflectionFactory<T> {

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
