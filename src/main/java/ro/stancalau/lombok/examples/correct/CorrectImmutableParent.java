package ro.stancalau.lombok.examples.correct;

import lombok.Value;
import ro.stancalau.lombok.api.ImmutableParent;
import ro.stancalau.lombok.api.MutablePerson;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Value
public class CorrectImmutableParent implements ImmutableParent {

    private String name;
    private Set<MutablePerson> children;

    public CorrectImmutableParent(String name) {
        this(name, Collections.emptySet());
    }

    //Needs to be manually implemented instead of relying on @AllArgsConstructor or @RequiredArgsConstructor
    public CorrectImmutableParent(String name, Set<MutablePerson> children) {
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
    //@Value will add @Getter too, which will return the reference of the mutable field,
    //so manual implementation is required to return a copy or immutable wrapper.
    public Set<MutablePerson> getChildren() {
        return new HashSet<>(children);
    }
}
