package ro.stancalau.lombok.badpractice.setters;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ro.stancalau.lombok.api.Parent;
import ro.stancalau.lombok.api.Person;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SideEffectFromSetterParent implements Parent {

    @NonNull
    private String name;
    @NonNull
    private Set<Person> children;

    public SideEffectFromSetterParent() {
        this(DEFAULT_NAME);
    }

    public SideEffectFromSetterParent(String name) {
        //Here we instantiate with new set, as Collections.emptySet() is immutable.
        this(name, new HashSet<>());
    }

    public SideEffectFromSetterParent(String name, Set<Person> children) {
        setName(name);
        setChildren(children);
    }

    @Override
    //Implemented manually because Lombok returns reference to field itself, not copy nor unmodifiable wrapper
    public Set<Person> getChildren() {
        return new HashSet<>(children);
    }

    @Override
    public void addChild(@NonNull Person child) {
        children.add(child);
    }
}
