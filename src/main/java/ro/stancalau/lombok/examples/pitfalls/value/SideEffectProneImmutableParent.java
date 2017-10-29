package ro.stancalau.lombok.examples.pitfalls.value;

import lombok.AllArgsConstructor;
import lombok.Value;
import ro.stancalau.lombok.api.ImmutableParent;
import ro.stancalau.lombok.api.MutablePerson;

import java.util.Collections;
import java.util.Set;

@Value
@AllArgsConstructor
public class SideEffectProneImmutableParent implements ImmutableParent {

    private String name;
    private Set<MutablePerson> children;

    public SideEffectProneImmutableParent(String name) {
        this(name, Collections.emptySet());
    }
}
