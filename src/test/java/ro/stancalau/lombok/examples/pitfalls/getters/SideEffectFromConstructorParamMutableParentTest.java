package ro.stancalau.lombok.examples.pitfalls.getters;

import ro.stancalau.lombok.api.MutableParent;
import ro.stancalau.lombok.api.MutablePerson;
import ro.stancalau.lombok.base.MutableParentTest;

import java.util.Set;

public class SideEffectFromConstructorParamMutableParentTest extends MutableParentTest {

    @Override
    public MutableParent createPerson(String name, Set<MutablePerson> children) {
        return new SideEffectFromConstructorParamMutableParent(name, children);
    }

    @Override
    public MutableParent createPerson(String name) {
        return new SideEffectFromConstructorParamMutableParent(name);
    }

    @Override
    public MutableParent createPerson() {
        return new SideEffectFromConstructorParamMutableParent();
    }
}
