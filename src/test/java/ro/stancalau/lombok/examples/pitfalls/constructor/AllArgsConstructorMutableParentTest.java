package ro.stancalau.lombok.examples.pitfalls.constructor;

import ro.stancalau.lombok.base.parent.ParentConstructorTests;

public class AllArgsConstructorMutableParentTest extends ParentConstructorTests<AllArgsConstructorMutableParent> {

    public AllArgsConstructorMutableParentTest() {
        super(AllArgsConstructorMutableParent.class);
    }
}