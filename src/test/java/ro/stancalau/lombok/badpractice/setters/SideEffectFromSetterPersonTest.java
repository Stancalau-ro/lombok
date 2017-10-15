package ro.stancalau.lombok.badpractice.setters;

import ro.stancalau.lombok.api.MutablePersonTest;
import ro.stancalau.lombok.api.Person;

import java.util.Set;

public class SideEffectFromSetterPersonTest extends MutablePersonTest {

    @Override
    public Person createPerson(String name, Set<Person> children) {
        return new SideEffectFromSetterPerson(name, children);
    }

    @Override
    public Person createPerson(String name) {
        return new SideEffectFromSetterPerson(name);
    }

    @Override
    public Person createPerson() {
        return new SideEffectFromSetterPerson();
    }
}