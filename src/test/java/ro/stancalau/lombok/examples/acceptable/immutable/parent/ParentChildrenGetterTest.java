package ro.stancalau.lombok.examples.acceptable.immutable.parent;

import ro.stancalau.lombok.base.parent.ParentChildrenGetterTests;
import ro.stancalau.lombok.examples.acceptable.ImmutableParentImpl;

public class ParentChildrenGetterTest extends ParentChildrenGetterTests<ImmutableParentImpl> {

    public ParentChildrenGetterTest() {
        super(ImmutableParentImpl.class);
    }
}
