package ro.stancalau.lombok.badpractice.constructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ro.stancalau.lombok.api.Human;

import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
public class LombokNoArgsConstructorHuman implements Human {

    private String name;
    private Set<Human> children;

    public LombokNoArgsConstructorHuman(String name, @NonNull Set<Human> children) {
        this.name = name;

        //Setting copy as otherwise, changes in passed set would mirror in this CorrectHuman instance's state.
        this.children = new HashSet<>(children);
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
