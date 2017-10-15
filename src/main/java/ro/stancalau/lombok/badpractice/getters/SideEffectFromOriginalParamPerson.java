package ro.stancalau.lombok.badpractice.getters;

import lombok.Getter;
import lombok.NonNull;
import ro.stancalau.lombok.api.Person;

import java.util.HashSet;
import java.util.Set;

@Getter
public class SideEffectFromOriginalParamPerson implements Person {

    private String name;
    private Set<Person> children;

    public SideEffectFromOriginalParamPerson(String name) {
        this.name = name;

        //Cannot be Collections.emptySet() as that would be immutable and the .add method would throw exception.
        this.children = new HashSet<>();
    }

    public SideEffectFromOriginalParamPerson(String name, @NonNull Set<Person> children) {
        this.name = name;

        //Here, there we should set a copy of the parameter set
        this.children = children;
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
