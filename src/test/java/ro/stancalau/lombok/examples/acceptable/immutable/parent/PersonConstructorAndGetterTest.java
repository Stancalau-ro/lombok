package ro.stancalau.lombok.examples.acceptable.immutable.parent;

import ro.stancalau.lombok.examples.acceptable.ImmutableParentImpl;
import ro.stancalau.lombok.tests.person.PersonConstructorAndGetterTests;

public class PersonConstructorAndGetterTest extends PersonConstructorAndGetterTests<ImmutableParentImpl> {

    public PersonConstructorAndGetterTest() {
        super(ImmutableParentImpl.class);
    }
}
