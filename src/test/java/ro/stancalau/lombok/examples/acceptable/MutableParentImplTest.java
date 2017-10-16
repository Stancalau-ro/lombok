package ro.stancalau.lombok.examples.acceptable;

import ro.stancalau.lombok.api.MutableParent;
import ro.stancalau.lombok.api.MutablePerson;
import ro.stancalau.lombok.base.MutableParentTest;

import java.util.Set;

public class MutableParentImplTest extends MutableParentTest {

    @Override
    public MutableParent createPerson(String name, Set<MutablePerson> children) {
        return new MutableParentImpl(name, children);
    }

    @Override
    public MutableParent createPerson(String name) {
        return new MutableParentImpl(name);
    }

    @Override
    public MutableParent createPerson() {
        return new MutableParentImpl();
    }
}