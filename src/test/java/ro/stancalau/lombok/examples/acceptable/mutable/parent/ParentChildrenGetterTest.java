package ro.stancalau.lombok.examples.acceptable.mutable.parent;

import ro.stancalau.lombok.examples.acceptable.MutableParentImpl;
import ro.stancalau.lombok.tests.parent.ParentChildrenGetterTests;

public class ParentChildrenGetterTest extends ParentChildrenGetterTests<MutableParentImpl> {

    public ParentChildrenGetterTest() {
        super(MutableParentImpl.class);
    }
}
