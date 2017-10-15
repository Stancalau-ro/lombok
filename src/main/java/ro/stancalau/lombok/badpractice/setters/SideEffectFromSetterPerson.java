package ro.stancalau.lombok.badpractice.setters;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ro.stancalau.lombok.api.Person;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SideEffectFromSetterPerson implements Person {

    private String name;
    private Set<Person> children;

    public SideEffectFromSetterPerson() {
        this(DEFAULT_NAME);
    }

    public SideEffectFromSetterPerson(@NonNull String name) {
        //Here we instantiate with new set, as Collections.emptySet() is immutable.
        this(name, new HashSet<>());
    }

    public SideEffectFromSetterPerson(@NonNull String name, @NonNull Set<Person> children) {
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
