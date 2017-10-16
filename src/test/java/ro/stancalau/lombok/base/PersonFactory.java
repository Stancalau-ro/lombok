package ro.stancalau.lombok.base;

import ro.stancalau.lombok.api.ImmutablePerson;

public interface PersonFactory<T extends ImmutablePerson> {

    T createPerson(String name);

    T createPerson();
}
