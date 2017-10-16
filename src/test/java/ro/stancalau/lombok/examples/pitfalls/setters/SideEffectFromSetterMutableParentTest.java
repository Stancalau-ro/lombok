package ro.stancalau.lombok.examples.pitfalls.setters;

import ro.stancalau.lombok.api.MutableParent;
import ro.stancalau.lombok.api.MutablePerson;
import ro.stancalau.lombok.base.MutableParentTest;

import java.util.Set;

public class SideEffectFromSetterMutableParentTest extends MutableParentTest {

    @Override
    public MutableParent createPerson(String name, Set<MutablePerson> children) {
        return new SideEffectFromSetterMutableParent(name, children);
    }

    @Override
    public MutableParent createPerson(String name) {
        return new SideEffectFromSetterMutableParent(name);
    }

    @Override
    public MutableParent createPerson() {
        return new SideEffectFromSetterMutableParent();
    }
}