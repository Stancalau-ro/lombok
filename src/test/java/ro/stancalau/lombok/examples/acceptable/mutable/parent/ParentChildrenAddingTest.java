package ro.stancalau.lombok.examples.acceptable.mutable.parent;

import ro.stancalau.lombok.examples.acceptable.MutableParentImpl;
import ro.stancalau.lombok.tests.parent.ParentChildrenAddingTests;

public class ParentChildrenAddingTest extends ParentChildrenAddingTests {

    public ParentChildrenAddingTest() {
        super(MutableParentImpl.class);
    }
}
