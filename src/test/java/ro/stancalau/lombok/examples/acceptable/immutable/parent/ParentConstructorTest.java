package ro.stancalau.lombok.examples.acceptable.immutable.parent;

import ro.stancalau.lombok.examples.acceptable.ImmutableParentImpl;
import ro.stancalau.lombok.tests.parent.ParentConstructorTests;

public class ParentConstructorTest extends ParentConstructorTests<ImmutableParentImpl> {

    public ParentConstructorTest() {
        super(ImmutableParentImpl.class);
    }
}
