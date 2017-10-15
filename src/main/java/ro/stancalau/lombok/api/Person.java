package ro.stancalau.lombok.api;

import lombok.NonNull;

import java.util.Set;

public interface Person {

    String DEFAULT_NAME = "JohnDoe";

    String getName();

    void setName(String name);

    Set<Person> getChildren();

    void setChildren(Set<Person> children);

    void addChild(@NonNull Person child);
}
