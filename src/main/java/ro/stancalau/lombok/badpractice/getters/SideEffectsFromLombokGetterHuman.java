package ro.stancalau.lombok.badpractice.getters;

import lombok.Getter;
import lombok.NonNull;
import ro.stancalau.lombok.api.Human;

import java.util.HashSet;
import java.util.Set;

@Getter
public class SideEffectsFromLombokGetterHuman implements Human {

    private String name;
    private Set<Human> children;

    public SideEffectsFromLombokGetterHuman(String name) {
        this.name = name;

        //Cannot be Collections.emptySet() as that would be immutable and the .add method would throw exception.
        this.children = new HashSet<>();
    }

    public SideEffectsFromLombokGetterHuman(String name, @NonNull Set<Human> children) {
        this.name = name;

        //Setting copy as otherwise, changes in passed set would mirror in this CorrectHuman instance's state.
        this.children = new HashSet<>(children);
    }

    @Override
    public void addChild(@NonNull Human child) {
        children.add(child);
    }
}
