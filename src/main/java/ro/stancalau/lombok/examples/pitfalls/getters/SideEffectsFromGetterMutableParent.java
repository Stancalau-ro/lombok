package ro.stancalau.lombok.examples.pitfalls.getters;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ro.stancalau.lombok.api.MutableParent;
import ro.stancalau.lombok.api.MutablePerson;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SideEffectsFromGetterMutableParent implements MutableParent {

    @NonNull
    private String name;
    @NonNull
    private Set<MutablePerson> children;

    public SideEffectsFromGetterMutableParent() {
        this(DEFAULT_NAME);
    }

    public SideEffectsFromGetterMutableParent(String name) {
        this(name, new HashSet<>());
    }

    public SideEffectsFromGetterMutableParent(String name, Set<MutablePerson> children) {
        this.name = name;

        //Setting copy as otherwise, changes in passed set would mirror in this instance's state.
        this.children = new HashSet<>(children);
    }

    @Override
    //Implemented manually because Lombok sets reference directly to field itself, not copying collection
    public void setChildren(Set<MutablePerson> children) {
        this.children = new HashSet<>(children);
    }

    @Override
    //It is best practice to only mutate object state via mutator methods and never use getters to inflict side-effects
    public void addChild(@NonNull MutablePerson child) {
        children.add(child);
    }
}
