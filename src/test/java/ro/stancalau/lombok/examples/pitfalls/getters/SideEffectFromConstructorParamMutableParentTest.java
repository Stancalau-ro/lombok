package ro.stancalau.lombok.examples.pitfalls.getters;

import ro.stancalau.lombok.base.parent.ParentConstructorTests;

public class SideEffectFromConstructorParamMutableParentTest extends ParentConstructorTests<SideEffectFromConstructorParamMutableParent> {

    public SideEffectFromConstructorParamMutableParentTest() {
        super(SideEffectFromConstructorParamMutableParent.class);
    }
}
