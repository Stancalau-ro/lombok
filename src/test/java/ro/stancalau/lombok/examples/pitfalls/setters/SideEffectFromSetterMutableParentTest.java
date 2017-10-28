package ro.stancalau.lombok.examples.pitfalls.setters;

import ro.stancalau.lombok.tests.parent.ParentConstructorTests;

public class SideEffectFromSetterMutableParentTest extends ParentConstructorTests<SideEffectFromSetterMutableParent> {

    public SideEffectFromSetterMutableParentTest() {
        super(SideEffectFromSetterMutableParent.class);
    }
}