package ro.stancalau.lombok.examples.acceptable.immutable.parent;

import ro.stancalau.lombok.base.parent.ParentConstructorTests;
import ro.stancalau.lombok.examples.acceptable.ImmutableParentImpl;

public class ParentConstructorTest extends ParentConstructorTests<ImmutableParentImpl> {

    public ParentConstructorTest() {
        super(ImmutableParentImpl.class);
    }
}
