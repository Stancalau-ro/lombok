package ro.stancalau.lombok.goodpractice;

import ro.stancalau.lombok.api.Person;
import ro.stancalau.lombok.api.PersonTest;

import java.util.Set;

public class CorrectPersonTest extends PersonTest {

    @Override
    protected Person createHuman(String name, Set<Person> children) {
        return new CorrectPerson(name, children);
    }

    @Override
    protected Person createHuman(String name) {
        return new CorrectPerson(name);
    }
}