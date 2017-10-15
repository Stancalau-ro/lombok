package ro.stancalau.lombok.api;

import java.util.Set;

public interface PersonFactory<T extends Person> {

    T createPerson(String name, Set<Person> children);

    T createPerson(String name);

    T createPerson();
}
