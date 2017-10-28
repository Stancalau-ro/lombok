package ro.stancalau.lombok.examples.pitfalls.constructor;


import ro.stancalau.lombok.api.MutableParent;
import ro.stancalau.lombok.tests.parent.ParentConstructorTests;

public class NoArgsConstructorMutableParentTest extends ParentConstructorTests<NoArgsConstructorMutableParent> {

    public NoArgsConstructorMutableParentTest(Class<MutableParent> clazz) {
        super(NoArgsConstructorMutableParent.class);
    }

}