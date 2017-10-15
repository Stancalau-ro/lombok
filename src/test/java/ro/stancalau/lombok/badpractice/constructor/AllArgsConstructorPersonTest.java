package ro.stancalau.lombok.badpractice.constructor;

import ro.stancalau.lombok.api.MutablePersonTest;
import ro.stancalau.lombok.api.Person;

import java.util.Set;

public class AllArgsConstructorPersonTest extends MutablePersonTest {

    @Override
    public Person createPerson(String name, Set<Person> children) {
        return new LombokAllArgsConstructorPerson(name, children);
    }

    @Override
    public Person createPerson(String name) {
        return new LombokAllArgsConstructorPerson(name);
    }

    @Override
    public Person createPerson() {
        return new LombokAllArgsConstructorPerson();
    }
}