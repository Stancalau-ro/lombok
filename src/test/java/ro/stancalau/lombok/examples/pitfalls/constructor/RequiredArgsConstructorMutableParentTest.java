package ro.stancalau.lombok.examples.pitfalls.constructor;

import ro.stancalau.lombok.tests.parent.ParentConstructorTests;

public class RequiredArgsConstructorMutableParentTest extends ParentConstructorTests<RequiredArgsConstructorMutableParent> {

    public RequiredArgsConstructorMutableParentTest() {
        super(RequiredArgsConstructorMutableParent.class);
    }
}