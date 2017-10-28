package ro.stancalau.lombok.examples.acceptable;

import lombok.Value;
import ro.stancalau.lombok.api.ImmutableParent;
import ro.stancalau.lombok.api.MutablePerson;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Value
public class ImmutableParentImpl implements ImmutableParent {

    private String name;
    private Set<MutablePerson> children;

    public ImmutableParentImpl(String name) {
        this(name, Collections.emptySet());
    }

    public ImmutableParentImpl(String name, Set<MutablePerson> children) {
        if (name == null) {
            throw new NullPointerException("Name cannot be null");
        }
        if (children == null) {
            throw new NullPointerException("Children set cannot be null");
        }
        this.name = name;
        this.children = new HashSet<>(children);
    }

    @Override
    public Set<MutablePerson> getChildren() {
        return new HashSet<>(children);
    }
}
