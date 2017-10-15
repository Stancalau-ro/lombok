package ro.stancalau.lombok.badpractice.getters;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ro.stancalau.lombok.api.Person;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SideEffectsFromGetterPerson implements Person {

    private String name;
    private Set<Person> children;

    public SideEffectsFromGetterPerson() {
        this(DEFAULT_NAME);
    }

    public SideEffectsFromGetterPerson(@NotNull String name) {
        this(name, new HashSet<>());
    }

    public SideEffectsFromGetterPerson(@NotNull String name, @NonNull Set<Person> children) {
        this.name = name;

        //Setting copy as otherwise, changes in passed set would mirror in this instance's state.
        this.children = new HashSet<>(children);
    }

    @Override
    //Implemented manually because Lombok sets reference directly to field itself, not copying collection
    public void setChildren(Set<Person> children) {
        this.children = new HashSet<>(children);
    }

    @Override
    public void addChild(@NonNull Person child) {
        children.add(child);
    }
}
