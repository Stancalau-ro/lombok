package ro.stancalau.lombok.base;

import ro.stancalau.lombok.api.Parent;
import ro.stancalau.lombok.api.Person;

import java.util.Set;

public interface ParentFactory<T extends Parent> extends PersonFactory<T> {

    T createPerson(String name, Set<Person> children);
}
