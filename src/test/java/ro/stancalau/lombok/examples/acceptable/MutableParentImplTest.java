package ro.stancalau.lombok.examples.acceptable;

import ro.stancalau.lombok.base.parent.ParentConstructorTests;

public class MutableParentImplTest extends ParentConstructorTests<MutableParentImpl> {

    public MutableParentImplTest() {
        super(MutableParentImpl.class);
    }
}