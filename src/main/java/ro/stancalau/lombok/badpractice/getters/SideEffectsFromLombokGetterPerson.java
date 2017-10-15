package ro.stancalau.lombok.badpractice.getters;

import lombok.Getter;
import lombok.NonNull;
import ro.stancalau.lombok.api.Person;

import java.util.HashSet;
import java.util.Set;

@Getter
public class SideEffectsFromLombokGetterPerson implements Person {

    private String name;
    private Set<Person> children;

    public SideEffectsFromLombokGetterPerson(String name) {
        this.name = name;

        //Cannot be Collections.emptySet() as that would be immutable and the .add method would throw exception.
        this.children = new HashSet<>();
    }

    public SideEffectsFromLombokGetterPerson(String name, @NonNull Set<Person> children) {
        this.name = name;

        //Setting copy as otherwise, changes in passed set would mirror in this CorrectPerson instance's state.
        this.children = new HashSet<>(children);
    }

    @Override
    public void addChild(@NonNull Person child) {
        children.add(child);
    }
}
