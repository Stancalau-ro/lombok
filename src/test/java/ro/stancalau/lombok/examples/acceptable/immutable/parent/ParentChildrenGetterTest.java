package ro.stancalau.lombok.examples.acceptable.immutable.parent;

import ro.stancalau.lombok.examples.acceptable.ImmutableParentImpl;
import ro.stancalau.lombok.tests.parent.ParentChildrenGetterTests;

public class ParentChildrenGetterTest extends ParentChildrenGetterTests<ImmutableParentImpl> {

    public ParentChildrenGetterTest() {
        super(ImmutableParentImpl.class);
    }
}
