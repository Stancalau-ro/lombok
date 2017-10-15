package ro.stancalau.lombok.examples.goodpractice;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ro.stancalau.lombok.api.Parent;
import ro.stancalau.lombok.api.Person;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CorrectParent implements Parent {

    @NonNull
    private String name;
    @NonNull
    private Set<Person> children;

    public CorrectParent() {
        this(DEFAULT_NAME);
    }

    public CorrectParent(String name) {
        this(name, Collections.emptySet());
    }

    public CorrectParent(String name, Set<Person> children) {
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
        //Setting copy as otherwise, changes in passed set would mirror in this instance's state.
        this.children = new HashSet<>(children);
    }

    @Override
    public void addChild(@NonNull Person child) {
        children.add(child);
    }
}
