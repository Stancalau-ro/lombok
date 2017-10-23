package ro.stancalau.lombok.factory;

import ro.stancalau.lombok.api.ImmutableParent;
import ro.stancalau.lombok.api.MutablePerson;

import java.util.Set;

public interface ParentFactory<T extends ImmutableParent> extends PersonFactory<T> {

    T createPerson(String name, Set<MutablePerson> children);
}
