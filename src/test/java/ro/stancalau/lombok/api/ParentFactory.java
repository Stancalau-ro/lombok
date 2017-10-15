package ro.stancalau.lombok.api;

import java.util.Set;

public interface ParentFactory<T extends Parent> extends PersonFactory<T> {

    T createPerson(String name, Set<Person> children);
}
