package ro.stancalau.lombok.examples.acceptable.immutable.person;

import ro.stancalau.lombok.examples.acceptable.ImmutablePersonImpl;
import ro.stancalau.lombok.tests.FieldVisibilityTests;

public class FieldVisibilityTest extends FieldVisibilityTests<ImmutablePersonImpl> {

    public FieldVisibilityTest() {
        super(ImmutablePersonImpl.class);
    }
}