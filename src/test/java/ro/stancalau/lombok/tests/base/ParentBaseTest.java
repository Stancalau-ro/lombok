package ro.stancalau.lombok.tests.base;

import org.junit.Before;
import ro.stancalau.lombok.api.ImmutableParent;
import ro.stancalau.lombok.api.MutablePerson;
import ro.stancalau.lombok.examples.correct.CorrectMutableParent;
import ro.stancalau.lombok.factory.ParentFactory;
import ro.stancalau.lombok.factory.ParentReflectionFactory;

import java.util.HashSet;
import java.util.Set;

import static ro.stancalau.lombok.tests.base.TestNames.BOY_NAME;
import static ro.stancalau.lombok.tests.base.TestNames.GIRL_NAME;

public abstract class ParentBaseTest<T extends ImmutableParent> extends ParameterizedTest implements ParentTest<T> {

    protected static final MutablePerson ILLEGITIMATE_CHILD = new CorrectMutableParent("Bob");
    protected Set<MutablePerson> globalChildren;

    private final ParentFactory<T> factory;

    @Before
    public void setUpChildren() throws Exception {
        globalChildren = new HashSet<>();
        globalChildren.add(new CorrectMutableParent(BOY_NAME));
        globalChildren.add(new CorrectMutableParent(GIRL_NAME));
    }

    public ParentBaseTest(Class<T> clazz) {
        factory = new ParentReflectionFactory<>(clazz);
    }

    @Override
    public T create(String name, Set<MutablePerson> children) {
        return factory.create(name, children);
    }

    @Override
    public T create(String name) {
        return factory.create(name);
    }

    @Override
    public T create() {
        return factory.create();
    }
}
