package ro.stancalau.lombok.api;

import lombok.NonNull;

import java.util.Set;

public interface MutableParent extends MutablePerson, ImmutableParent {

    void setChildren(Set<MutablePerson> children);

    void addChild(@NonNull MutablePerson child);
}
