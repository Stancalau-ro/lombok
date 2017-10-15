package ro.stancalau.lombok.base;

import ro.stancalau.lombok.api.Person;

public interface PersonFactory<T extends Person> {

    T createPerson(String name);

    T createPerson();
}
