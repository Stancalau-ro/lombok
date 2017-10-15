package ro.stancalau.lombok.api;

import lombok.NonNull;

import java.util.Set;

public interface Human {

    String getName();

    Set<Human> getChildren();

    void addChild(@NonNull Human child);
}
