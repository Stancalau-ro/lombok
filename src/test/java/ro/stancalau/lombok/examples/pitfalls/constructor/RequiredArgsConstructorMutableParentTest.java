package ro.stancalau.lombok.examples.pitfalls.constructor;

import ro.stancalau.lombok.api.MutableParent;
import ro.stancalau.lombok.api.MutablePerson;
import ro.stancalau.lombok.base.MutableParentTest;

import java.util.Set;

public class RequiredArgsConstructorMutableParentTest extends MutableParentTest {

    @Override
    public MutableParent createPerson(String name, Set<MutablePerson> children) {
        return new RequiredArgsConstructorMutableParent(name, children);
    }

    @Override
    public MutableParent createPerson(String name) {
        return new RequiredArgsConstructorMutableParent(name);
    }

    @Override
    public MutableParent createPerson() {
        return new RequiredArgsConstructorMutableParent();
    }
}