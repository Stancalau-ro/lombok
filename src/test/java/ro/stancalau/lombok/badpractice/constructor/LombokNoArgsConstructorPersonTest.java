package ro.stancalau.lombok.badpractice.constructor;


import ro.stancalau.lombok.api.Person;
import ro.stancalau.lombok.api.PersonTest;

import java.util.Set;

public class LombokNoArgsConstructorPersonTest extends PersonTest {

    @Override
    protected Person createHuman(String name, Set<Person> children) {
        return new LombokNoArgsConstructorPerson(name, children);
    }

    @Override
    protected Person createHuman(String name) {
        return new LombokNoArgsConstructorPerson();
    }
}