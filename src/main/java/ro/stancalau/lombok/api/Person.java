package ro.stancalau.lombok.api;

import lombok.NonNull;

import java.util.Set;

public interface Person {

    String DEFAULT_NAME = "JohnDoe";

    String getName();

    Set<Person> getChildren();

    void addChild(@NonNull Person child);
}
