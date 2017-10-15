package ro.stancalau.lombok.badpractice.getters;

import ro.stancalau.lombok.api.MutablePersonTest;
import ro.stancalau.lombok.api.Person;

import java.util.Set;

public class SideEffectFromConstructorParamPersonTest extends MutablePersonTest {

    @Override
    public Person createPerson(String name, Set<Person> children) {
        return new SideEffectFromConstructorParamPerson(name, children);
    }

    @Override
    public Person createPerson(String name) {
        return new SideEffectFromConstructorParamPerson(name);
    }

    @Override
    public Person createPerson() {
        return new SideEffectFromConstructorParamPerson();
    }
}
