package ro.stancalau.lombok.examples.pitfalls.setters;

import ro.stancalau.lombok.base.parent.ParentConstructorTests;

public class SideEffectFromSetterMutableParentTest extends ParentConstructorTests<SideEffectFromSetterMutableParent> {

    public SideEffectFromSetterMutableParentTest() {
        super(SideEffectFromSetterMutableParent.class);
    }
}