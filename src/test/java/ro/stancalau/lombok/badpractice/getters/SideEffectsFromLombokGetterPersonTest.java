package ro.stancalau.lombok.badpractice.getters;

import ro.stancalau.lombok.api.Person;
import ro.stancalau.lombok.api.PersonTest;

import java.util.Set;

public class SideEffectsFromLombokGetterPersonTest extends PersonTest {

    @Override
    protected Person createHuman(String name, Set<Person> children) {
        return new SideEffectsFromLombokGetterPerson(name, children);
    }

    @Override
    protected Person createHuman(String name) {
        return new SideEffectsFromLombokGetterPerson(name);
    }
}