package ro.stancalau.lombok.examples.pitfalls.constructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ro.stancalau.lombok.api.MutableParent;
import ro.stancalau.lombok.api.MutablePerson;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class NoArgsConstructorMutableParent implements MutableParent {

    @NonNull
    private String name;
    @NonNull
    private Set<MutablePerson> children;

    public NoArgsConstructorMutableParent(String name) {
        this(name, new HashSet<>());
    }

    public NoArgsConstructorMutableParent(String name, Set<MutablePerson> children) {
        setName(name);
        setChildren(children);
    }

    @Override
    //Implemented manually because Lombok returns reference to field itself, not copy nor unmodifiable wrapper
    public Set<MutablePerson> getChildren() {
        return new HashSet<>(children);
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
