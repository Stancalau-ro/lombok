package ro.stancalau.lombok.badpractice.constructor;


import ro.stancalau.lombok.api.Parent;
import ro.stancalau.lombok.api.ParentTest;
import ro.stancalau.lombok.api.Person;

import java.util.Set;

public class NoArgsConstructorParentTest extends ParentTest {

    @Override
    public Parent createPerson(String name, Set<Person> children) {
        return new LombokNoArgsConstructorParent(name, children);
    }

    @Override
    public Parent createPerson(String name) {
        return new LombokNoArgsConstructorParent(name);
    }

    @Override
    public Parent createPerson() {
        return new LombokNoArgsConstructorParent();
    }
}