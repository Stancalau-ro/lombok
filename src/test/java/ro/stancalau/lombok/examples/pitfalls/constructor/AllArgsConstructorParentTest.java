package ro.stancalau.lombok.examples.pitfalls.constructor;

import ro.stancalau.lombok.api.Parent;
import ro.stancalau.lombok.api.Person;
import ro.stancalau.lombok.base.ParentTest;

import java.util.Set;

public class AllArgsConstructorParentTest extends ParentTest {

    @Override
    public Parent createPerson(String name, Set<Person> children) {
        return new LombokAllArgsConstructorParent(name, children);
    }

    @Override
    public Parent createPerson(String name) {
        return new LombokAllArgsConstructorParent(name);
    }

    @Override
    public Parent createPerson() {
        return new LombokAllArgsConstructorParent();
    }
}