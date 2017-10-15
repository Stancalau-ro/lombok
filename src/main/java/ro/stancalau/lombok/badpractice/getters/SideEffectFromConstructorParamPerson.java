package ro.stancalau.lombok.badpractice.getters;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ro.stancalau.lombok.api.Person;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SideEffectFromConstructorParamPerson implements Person {

    private String name;
    private Set<Person> children;

    public SideEffectFromConstructorParamPerson() {
        this(DEFAULT_NAME);
    }

    public SideEffectFromConstructorParamPerson(@NotNull String name) {
        this(name, new HashSet<>());
    }

    public SideEffectFromConstructorParamPerson(@NotNull String name, @NonNull Set<Person> children) {
        setName(name);

        //Here, there we should set a copy of the parameter set, or call the setter
        this.children = children;
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
