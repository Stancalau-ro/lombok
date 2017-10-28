package ro.stancalau.lombok.examples.acceptable.immutable.parent;

import ro.stancalau.lombok.base.FieldVisibilityTests;
import ro.stancalau.lombok.examples.acceptable.ImmutableParentImpl;

public class FieldVisibilityTest extends FieldVisibilityTests<ImmutableParentImpl> {

    public FieldVisibilityTest() {
        super(ImmutableParentImpl.class);
    }
}