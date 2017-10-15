package ro.stancalau.lombok.examples.badpractice.setters;

import ro.stancalau.lombok.api.Parent;
import ro.stancalau.lombok.api.Person;
import ro.stancalau.lombok.base.ParentTest;

import java.util.Set;

public class SideEffectFromSetterParentTest extends ParentTest {

    @Override
    public Parent createPerson(String name, Set<Person> children) {
        return new SideEffectFromSetterParent(name, children);
    }

    @Override
    public Parent createPerson(String name) {
        return new SideEffectFromSetterParent(name);
    }

    @Override
    public Parent createPerson() {
        return new SideEffectFromSetterParent();
    }
}