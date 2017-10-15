package ro.stancalau.lombok.badpractice.constructor;

import ro.stancalau.lombok.api.MutablePersonTest;
import ro.stancalau.lombok.api.Person;

import java.util.Set;

public class RequiredArgsConstructorPersonTest extends MutablePersonTest {

    @Override
    public Person createPerson(String name, Set<Person> children) {
        return new LombokRequiredArgsConstructorPerson(name, children);
    }

    @Override
    public Person createPerson(String name) {
        return new LombokRequiredArgsConstructorPerson(name);
    }

    @Override
    public Person createPerson() {
        return new LombokRequiredArgsConstructorPerson();
    }
}