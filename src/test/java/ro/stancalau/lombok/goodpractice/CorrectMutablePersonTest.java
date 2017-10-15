package ro.stancalau.lombok.goodpractice;

import ro.stancalau.lombok.api.MutablePersonTest;
import ro.stancalau.lombok.api.Person;

import java.util.Set;

public class CorrectMutablePersonTest extends MutablePersonTest {

    @Override
    public Person createPerson(String name, Set<Person> children) {
        return new CorrectMutablePerson(name, children);
    }

    @Override
    public Person createPerson(String name) {
        return new CorrectMutablePerson(name);
    }

    @Override
    public Person createPerson() {
        return new CorrectMutablePerson();
    }
}