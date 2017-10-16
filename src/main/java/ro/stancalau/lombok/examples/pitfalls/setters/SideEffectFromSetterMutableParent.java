package ro.stancalau.lombok.examples.pitfalls.setters;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ro.stancalau.lombok.api.MutableParent;
import ro.stancalau.lombok.api.MutablePerson;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SideEffectFromSetterMutableParent implements MutableParent {

    @NonNull
    private String name;
    @NonNull
    private Set<MutablePerson> children;

    public SideEffectFromSetterMutableParent() {
        this(DEFAULT_NAME);
    }

    public SideEffectFromSetterMutableParent(String name) {
        //Here we instantiate with new set, as Collections.emptySet() is immutable.
        this(name, new HashSet<>());
    }

    public SideEffectFromSetterMutableParent(String name, Set<MutablePerson> children) {
        setName(name);
        setChildren(children);
    }

    @Override
    //Implemented manually because Lombok returns reference to field itself, not copy nor unmodifiable wrapper
    public Set<MutablePerson> getChildren() {
        return new HashSet<>(children);
    }

    @Override
    public void addChild(@NonNull MutablePerson child) {
        children.add(child);
    }
}
