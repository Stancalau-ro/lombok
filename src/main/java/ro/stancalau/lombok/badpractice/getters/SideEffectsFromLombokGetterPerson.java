package ro.stancalau.lombok.badpractice.getters;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.NonNull;
import ro.stancalau.lombok.api.Person;

import java.util.HashSet;
import java.util.Set;

@Getter
public class SideEffectsFromLombokGetterPerson implements Person {

    private String name;
    private Set<Person> children;

    public SideEffectsFromLombokGetterPerson() {
        this(DEFAULT_NAME);
    }

    public SideEffectsFromLombokGetterPerson(@NotNull String name) {
        this(name, new HashSet<>());
    }

    public SideEffectsFromLombokGetterPerson(@NotNull String name, @NonNull Set<Person> children) {
        this.name = name;

        //Setting copy as otherwise, changes in passed set would mirror in this instance's state.
        this.children = new HashSet<>(children);
    }

    @Override
    public void addChild(@NonNull Person child) {
        children.add(child);
    }
}
