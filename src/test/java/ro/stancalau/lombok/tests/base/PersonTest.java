package ro.stancalau.lombok.tests.base;

import ro.stancalau.lombok.api.ImmutablePerson;
import ro.stancalau.lombok.factory.PersonFactory;

public interface PersonTest<T extends ImmutablePerson> extends PersonFactory<T> {
}
