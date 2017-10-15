package ro.stancalau.lombok.badpractice.getters;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ro.stancalau.lombok.api.Parent;
import ro.stancalau.lombok.api.Person;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SideEffectsFromGetterParent implements Parent {

    private String name;
    private Set<Person> children;

    public SideEffectsFromGetterParent() {
        this(DEFAULT_NAME);
    }

    public SideEffectsFromGetterParent(@NotNull String name) {
        this(name, new HashSet<>());
    }

    public SideEffectsFromGetterParent(@NotNull String name, @NonNull Set<Person> children) {
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
