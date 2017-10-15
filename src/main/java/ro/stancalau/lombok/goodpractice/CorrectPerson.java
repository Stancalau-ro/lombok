package ro.stancalau.lombok.goodpractice;

import lombok.Getter;
import lombok.NonNull;
import ro.stancalau.lombok.api.Person;

import java.util.HashSet;
import java.util.Set;

@Getter
public class CorrectPerson implements Person {

    private String name;
    private Set<Person> children;

    public CorrectPerson(String name) {
        this.name = name;

        //Cannot be Collections.emptySet() as that would be immutable and the .add method would throw exception.
        this.children = new HashSet<>();
    }

    public CorrectPerson(String name, @NonNull Set<Person> children) {
        this.name = name;

        //Setting copy as otherwise, changes in passed set would mirror in this CorrectPerson instance's state.
        this.children = new HashSet<>(children);
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
