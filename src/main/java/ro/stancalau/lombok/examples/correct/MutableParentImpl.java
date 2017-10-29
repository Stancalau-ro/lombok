package ro.stancalau.lombok.examples.correct;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ro.stancalau.lombok.api.MutableParent;
import ro.stancalau.lombok.api.MutablePerson;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class MutableParentImpl implements MutableParent {

    @NonNull
    private String name;
    @NonNull
    private Set<MutablePerson> children;

    public MutableParentImpl() {
        this(DEFAULT_NAME);
    }

    public MutableParentImpl(String name) {
        this(name, Collections.emptySet());
    }

    //Using @AllArgsConstructor would not call the setter, but assign reference directly even for mutable types
    public MutableParentImpl(String name, Set<MutablePerson> children) {
        setName(name);
        setChildren(children);
    }

    @Override
    //Implemented manually because Lombok returns reference to field itself, not copy nor unmodifiable wrapper
    public Set<MutablePerson> getChildren() {
        return new HashSet<>(children);
    }

    @Override
    //Implemented manually because Lombok sets reference directly to field itself, not copying collection
    public void setChildren(Set<MutablePerson> children) {
        //Setting copy as otherwise, changes in passed set would mirror in this instance's state.
        this.children = new HashSet<>(children);
    }

    @Override
    //It is best practice to only mutate object state via mutator methods and never use getters to inflict side-effects
    public void addChild(@NonNull MutablePerson child) {
        children.add(child);
    }
}
