package ro.stancalau.lombok.factory;

import ro.stancalau.lombok.api.ImmutablePerson;

public interface PersonFactory<T extends ImmutablePerson> {

    T create(String name);

    T create();
}
