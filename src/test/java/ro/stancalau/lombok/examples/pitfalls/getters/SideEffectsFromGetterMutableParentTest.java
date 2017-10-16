package ro.stancalau.lombok.examples.pitfalls.getters;

import ro.stancalau.lombok.api.MutableParent;
import ro.stancalau.lombok.api.MutablePerson;
import ro.stancalau.lombok.base.MutableParentTest;

import java.util.Set;

public class SideEffectsFromGetterMutableParentTest extends MutableParentTest {

    @Override
    public MutableParent createPerson(String name, Set<MutablePerson> children) {
        return new SideEffectsFromGetterMutableParent(name, children);
    }

    @Override
    public MutableParent createPerson(String name) {
        return new SideEffectsFromGetterMutableParent(name);
    }

    @Override
    public MutableParent createPerson() {
        return new SideEffectsFromGetterMutableParent();
    }
}