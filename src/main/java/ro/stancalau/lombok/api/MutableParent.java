package ro.stancalau.lombok.api;

import lombok.NonNull;

import java.util.Set;

public interface MutableParent extends MutablePerson {

    Set<MutablePerson> getChildren();

    void setChildren(Set<MutablePerson> children);

    void addChild(@NonNull MutablePerson child);
}
