package ro.stancalau.lombok.api;

import java.util.Set;

public interface ImmutableParent extends ImmutablePerson {

    Set<MutablePerson> getChildren();
}
