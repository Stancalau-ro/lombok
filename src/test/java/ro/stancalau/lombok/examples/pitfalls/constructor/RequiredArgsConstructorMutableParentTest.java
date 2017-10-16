package ro.stancalau.lombok.examples.pitfalls.constructor;

import ro.stancalau.lombok.api.MutableParent;
import ro.stancalau.lombok.api.MutablePerson;
import ro.stancalau.lombok.base.MutableParentTest;

import java.util.Set;

public class RequiredArgsConstructorMutableParentTest extends MutableParentTest {

    @Override
    public MutableParent createPerson(String name, Set<MutablePerson> children) {
        return new LombokRequiredArgsConstructorMutableParent(name, children);
    }

    @Override
    public MutableParent createPerson(String name) {
        return new LombokRequiredArgsConstructorMutableParent(name);
    }

    @Override
    public MutableParent createPerson() {
        return new LombokRequiredArgsConstructorMutableParent();
    }
}