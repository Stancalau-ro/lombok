package ro.stancalau.lombok.examples.badpractice.getters;

import ro.stancalau.lombok.api.Parent;
import ro.stancalau.lombok.api.Person;
import ro.stancalau.lombok.base.ParentTest;

import java.util.Set;

public class SideEffectsFromGetterParentTest extends ParentTest {

    @Override
    public Parent createPerson(String name, Set<Person> children) {
        return new SideEffectsFromGetterParent(name, children);
    }

    @Override
    public Parent createPerson(String name) {
        return new SideEffectsFromGetterParent(name);
    }

    @Override
    public Parent createPerson() {
        return new SideEffectsFromGetterParent();
    }
}