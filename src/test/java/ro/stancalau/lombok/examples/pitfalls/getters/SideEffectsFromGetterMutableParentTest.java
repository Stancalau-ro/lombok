package ro.stancalau.lombok.examples.pitfalls.getters;

import ro.stancalau.lombok.base.parent.ParentConstructorTests;

public class SideEffectsFromGetterMutableParentTest extends ParentConstructorTests<SideEffectsFromGetterMutableParent> {

    public SideEffectsFromGetterMutableParentTest() {
        super(SideEffectsFromGetterMutableParent.class);
    }
}