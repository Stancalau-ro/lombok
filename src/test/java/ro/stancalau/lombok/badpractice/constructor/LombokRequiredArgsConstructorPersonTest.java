package ro.stancalau.lombok.badpractice.constructor;

import ro.stancalau.lombok.api.Person;
import ro.stancalau.lombok.api.PersonTest;

import java.util.Set;

public class LombokRequiredArgsConstructorPersonTest extends PersonTest {

    @Override
    protected Person createPerson(String name, Set<Person> children) {
        return new LombokRequiredArgsConstructorPerson(name, children);
    }

    @Override
    protected Person createPerson(String name) {
        return new LombokRequiredArgsConstructorPerson(name);
    }

    @Override
    protected Person createPerson() {
        return new LombokRequiredArgsConstructorPerson();
    }
}