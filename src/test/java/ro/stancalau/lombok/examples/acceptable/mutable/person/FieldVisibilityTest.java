package ro.stancalau.lombok.examples.acceptable.mutable.person;

import ro.stancalau.lombok.examples.acceptable.MutablePersonImpl;
import ro.stancalau.lombok.tests.FieldVisibilityTests;

public class FieldVisibilityTest extends FieldVisibilityTests<MutablePersonImpl> {

    public FieldVisibilityTest() {
        super(MutablePersonImpl.class);
    }
}