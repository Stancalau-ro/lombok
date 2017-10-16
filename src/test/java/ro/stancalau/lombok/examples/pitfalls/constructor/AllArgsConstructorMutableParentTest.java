package ro.stancalau.lombok.examples.pitfalls.constructor;

import ro.stancalau.lombok.api.MutableParent;
import ro.stancalau.lombok.api.MutablePerson;
import ro.stancalau.lombok.base.MutableParentTest;

import java.util.Set;

public class AllArgsConstructorMutableParentTest extends MutableParentTest {

    @Override
    public MutableParent createPerson(String name, Set<MutablePerson> children) {
        return new LombokAllArgsConstructorMutableParent(name, children);
    }

    @Override
    public MutableParent createPerson(String name) {
        return new LombokAllArgsConstructorMutableParent(name);
    }

    @Override
    public MutableParent createPerson() {
        return new LombokAllArgsConstructorMutableParent();
    }
}