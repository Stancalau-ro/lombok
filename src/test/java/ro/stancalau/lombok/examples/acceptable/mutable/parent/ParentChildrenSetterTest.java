package ro.stancalau.lombok.examples.acceptable.mutable.parent;

import ro.stancalau.lombok.examples.acceptable.MutableParentImpl;
import ro.stancalau.lombok.tests.parent.ParentChildrenSetterTests;

public class ParentChildrenSetterTest extends ParentChildrenSetterTests<MutableParentImpl> {

    public ParentChildrenSetterTest() {
        super(MutableParentImpl.class);
    }
}
