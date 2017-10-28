package ro.stancalau.lombok.examples.acceptable.mutable.parent;

import ro.stancalau.lombok.examples.acceptable.MutableParentImpl;
import ro.stancalau.lombok.tests.parent.ParentConstructorTests;

public class ParentConstructorTest extends ParentConstructorTests<MutableParentImpl> {

    public ParentConstructorTest() {
        super(MutableParentImpl.class);
    }
}
