package ro.stancalau.lombok.examples.acceptable.mutable.parent;

import ro.stancalau.lombok.examples.acceptable.MutableParentImpl;
import ro.stancalau.lombok.tests.person.PersonConstructorAndGetterTests;

public class PersonConstructorAndGetterTest extends PersonConstructorAndGetterTests<MutableParentImpl> {

    public PersonConstructorAndGetterTest() {
        super(MutableParentImpl.class);
    }
}
