package ro.stancalau.lombok.tests.base;

import ro.stancalau.lombok.api.ImmutablePerson;
import ro.stancalau.lombok.factory.PersonReflectionFactory;

public class PersonBaseTest<T extends ImmutablePerson> extends PersonReflectionFactory<T> {

    public PersonBaseTest(Class<T> clazz) {
        super(clazz);
    }
}
