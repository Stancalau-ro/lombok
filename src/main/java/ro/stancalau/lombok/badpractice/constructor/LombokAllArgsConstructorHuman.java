package ro.stancalau.lombok.badpractice.constructor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import ro.stancalau.lombok.api.Human;

import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
public class LombokAllArgsConstructorHuman implements Human {

    private String name;
    private Set<Human> children;

    public LombokAllArgsConstructorHuman(String name) {
        this.name = name;

        //Cannot be Collections.emptySet() as that would be immutable and the .add method would throw exception.
        this.children = new HashSet<>();
    }

    @Override
    //Implemented manually because Lombok returns reference to field itself, not copy nor unmodifiable wrapper
    public Set<Human> getChildren() {
        return new HashSet<>(children);
    }

    @Override
    public void addChild(@NonNull Human child) {
        children.add(child);
    }
}
