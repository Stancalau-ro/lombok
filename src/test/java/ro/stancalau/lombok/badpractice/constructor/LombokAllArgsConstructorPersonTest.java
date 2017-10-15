package ro.stancalau.lombok.badpractice.constructor;

import ro.stancalau.lombok.api.Person;
import ro.stancalau.lombok.api.PersonTest;

import java.util.Set;

public class LombokAllArgsConstructorPersonTest extends PersonTest {

    @Override
    protected Person createPerson(String name, Set<Person> children) {
        return new LombokAllArgsConstructorPerson(name, children);
    }

    @Override
    protected Person createPerson(String name) {
        return new LombokAllArgsConstructorPerson(name);
    }

    @Override
    protected Person createPerson() {
        return new LombokAllArgsConstructorPerson();
    }
}