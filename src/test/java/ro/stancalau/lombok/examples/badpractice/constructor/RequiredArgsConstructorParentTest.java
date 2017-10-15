package ro.stancalau.lombok.examples.badpractice.constructor;

import ro.stancalau.lombok.api.Parent;
import ro.stancalau.lombok.api.Person;
import ro.stancalau.lombok.base.ParentTest;

import java.util.Set;

public class RequiredArgsConstructorParentTest extends ParentTest {

    @Override
    public Parent createPerson(String name, Set<Person> children) {
        return new LombokRequiredArgsConstructorParent(name, children);
    }

    @Override
    public Parent createPerson(String name) {
        return new LombokRequiredArgsConstructorParent(name);
    }

    @Override
    public Parent createPerson() {
        return new LombokRequiredArgsConstructorParent();
    }
}