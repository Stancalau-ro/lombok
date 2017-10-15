package ro.stancalau.lombok.badpractice.constructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ro.stancalau.lombok.api.Person;

import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
public class LombokNoArgsConstructorPerson implements Person {

    private String name;
    private Set<Person> children;

    public LombokNoArgsConstructorPerson(String name, @NonNull Set<Person> children) {
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
