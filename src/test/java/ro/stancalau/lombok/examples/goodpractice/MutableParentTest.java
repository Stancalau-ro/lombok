package ro.stancalau.lombok.examples.goodpractice;

import ro.stancalau.lombok.api.Parent;
import ro.stancalau.lombok.api.Person;
import ro.stancalau.lombok.base.ParentTest;

import java.util.Set;

public class MutableParentTest extends ParentTest {

    @Override
    public Parent createPerson(String name, Set<Person> children) {
        return new MutableParent(name, children);
    }

    @Override
    public Parent createPerson(String name) {
        return new MutableParent(name);
    }

    @Override
    public Parent createPerson() {
        return new MutableParent();
    }
}