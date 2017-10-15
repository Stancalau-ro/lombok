package ro.stancalau.lombok.examples.badpractice.constructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ro.stancalau.lombok.api.Parent;
import ro.stancalau.lombok.api.Person;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class LombokNoArgsConstructorParent implements Parent {

    @NonNull
    private String name;
    @NonNull
    private Set<Person> children;

    public LombokNoArgsConstructorParent(String name) {
        this(name, new HashSet<>());
    }

    public LombokNoArgsConstructorParent(String name, Set<Person> children) {
        setName(name);
        setChildren(children);
    }

    @Override
    //Implemented manually because Lombok returns reference to field itself, not copy nor unmodifiable wrapper
    public Set<Person> getChildren() {
        return new HashSet<>(children);
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
