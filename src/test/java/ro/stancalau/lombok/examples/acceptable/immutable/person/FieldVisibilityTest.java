package ro.stancalau.lombok.examples.acceptable.immutable.person;

import ro.stancalau.lombok.base.FieldVisibilityTests;
import ro.stancalau.lombok.examples.acceptable.ImmutablePersonImpl;

public class FieldVisibilityTest extends FieldVisibilityTests<ImmutablePersonImpl> {

    public FieldVisibilityTest() {
        super(ImmutablePersonImpl.class);
    }
}