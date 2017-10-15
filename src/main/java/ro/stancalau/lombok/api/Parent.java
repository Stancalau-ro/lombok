package ro.stancalau.lombok.api;

import lombok.NonNull;

import java.util.Set;

public interface Parent extends Person {

    Set<Person> getChildren();

    void setChildren(Set<Person> children);

    void addChild(@NonNull Person child);
}
