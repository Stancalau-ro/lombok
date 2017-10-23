package ro.stancalau.lombok.examples.acceptable;

import lombok.Value;
import ro.stancalau.lombok.api.ImmutableParent;
import ro.stancalau.lombok.api.MutablePerson;

import java.util.HashSet;
import java.util.Set;

@Value
public class ImmutableParentImpl implements ImmutableParent {

    private String name;
    private Set<MutablePerson> children;

    public ImmutableParentImpl(String name, Set<MutablePerson> children) {
        this.name = name;
        this.children = new HashSet<>(children);
    }

    @Override
    public Set<MutablePerson> getChildren() {
        return new HashSet<>(children);
    }
}
