package ro.stancalau.lombok.examples.pitfalls.constructor;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ro.stancalau.lombok.api.MutableParent;
import ro.stancalau.lombok.api.MutablePerson;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SideEffectFromConstructorParamMutableParent implements MutableParent {

    @NonNull
    private String name;
    @NonNull
    private Set<MutablePerson> children;

    public SideEffectFromConstructorParamMutableParent() {
        this(DEFAULT_NAME);
    }

    public SideEffectFromConstructorParamMutableParent(String name) {
        this(name, new HashSet<>());
    }

    public SideEffectFromConstructorParamMutableParent(String name, Set<MutablePerson> children) {
        setName(name);

        //Here, there we should set a copy of the parameter set, or call the setter
        this.children = children;
    }

    @Override
    //Implemented manually because Lombok returns reference to field itself, not copy nor unmodifiable wrapper
    public Set<MutablePerson> getChildren() {
        return new HashSet<>(children);
    }

    @Override
    //Implemented manually because Lombok sets reference directly to field itself, not copying collection
    public void setChildren(Set<MutablePerson> children) {
        this.children = new HashSet<>(children);
    }

    @Override
    public void addChild(@NonNull MutablePerson child) {
        children.add(child);
    }
}
