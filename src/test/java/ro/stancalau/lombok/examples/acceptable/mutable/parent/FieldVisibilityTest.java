package ro.stancalau.lombok.examples.acceptable.mutable.parent;

import ro.stancalau.lombok.examples.acceptable.MutableParentImpl;
import ro.stancalau.lombok.tests.FieldVisibilityTests;

public class FieldVisibilityTest extends FieldVisibilityTests<MutableParentImpl> {

    public FieldVisibilityTest() {
        super(MutableParentImpl.class);
    }
}