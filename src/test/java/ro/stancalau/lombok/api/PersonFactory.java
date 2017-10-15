package ro.stancalau.lombok.api;

import java.util.Set;

public interface PersonFactory {

    Person createPerson(String name, Set<Person> children);

    Person createPerson(String name);

    Person createPerson();
}
