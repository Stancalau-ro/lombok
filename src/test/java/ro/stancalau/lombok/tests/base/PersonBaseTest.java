package ro.stancalau.lombok.tests.base;

import ro.stancalau.lombok.api.ImmutablePerson;
import ro.stancalau.lombok.factory.PersonFactory;
import ro.stancalau.lombok.factory.PersonReflectionFactory;

public abstract class PersonBaseTest<T extends ImmutablePerson> extends ParameterizedTest implements PersonTest<T> {

    private final PersonFactory<T> factory;

    public PersonBaseTest(Class<T> clazz) {
        factory = new PersonReflectionFactory<>(clazz);
    }

    @Override
    public T create(String name) {
        return factory.create(name);
    }

    @Override
    public T create() {
        return factory.create();
    }
}
