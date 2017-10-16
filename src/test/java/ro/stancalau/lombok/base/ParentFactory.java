package ro.stancalau.lombok.base;

import ro.stancalau.lombok.api.MutableParent;
import ro.stancalau.lombok.api.MutablePerson;

import java.util.Set;

public interface ParentFactory<T extends MutableParent> extends PersonFactory<T> {

    T createPerson(String name, Set<MutablePerson> children);
}
