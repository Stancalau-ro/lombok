package ro.stancalau.lombok.badpractice.constructor;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ro.stancalau.lombok.api.Parent;
import ro.stancalau.lombok.api.Person;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class LombokRequiredArgsConstructorParent implements Parent {

    @NonNull
    private String name;
    @NonNull
    private Set<Person> children;

    public LombokRequiredArgsConstructorParent() {
        this(DEFAULT_NAME);
    }

    public LombokRequiredArgsConstructorParent(String name) {
        this(name, new HashSet<>());
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
