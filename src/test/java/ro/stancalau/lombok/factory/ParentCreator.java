package ro.stancalau.lombok.factory;

import org.junit.Before;
import ro.stancalau.lombok.api.ImmutableParent;
import ro.stancalau.lombok.api.MutablePerson;
import ro.stancalau.lombok.examples.acceptable.MutableParentImpl;

import java.util.HashSet;
import java.util.Set;

public class ParentCreator<T extends ImmutableParent> extends ParentReflectionFactory<T> {

    protected static final String NAME = "Joe";
    protected static final String NEW_NAME = "Jerome";
    protected static final String BOY_NAME = "Joel";
    protected static final String GIRL_NAME = "Jane";

    protected static final MutablePerson ILLEGITIMATE_CHILD = new MutableParentImpl("Bob");

    protected Set<MutablePerson> globalChildren;

    @Before
    public void setUpChildren() throws Exception {
        globalChildren = new HashSet<>();
        globalChildren.add(new MutableParentImpl(BOY_NAME));
        globalChildren.add(new MutableParentImpl(GIRL_NAME));
    }

    public ParentCreator(Class<T> clazz) {
        super(clazz);
    }
}
