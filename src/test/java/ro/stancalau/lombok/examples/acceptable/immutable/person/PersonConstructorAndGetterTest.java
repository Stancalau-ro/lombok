package ro.stancalau.lombok.examples.acceptable.immutable.person;

import ro.stancalau.lombok.examples.acceptable.ImmutablePersonImpl;
import ro.stancalau.lombok.tests.person.PersonConstructorAndGetterTests;

public class PersonConstructorAndGetterTest extends PersonConstructorAndGetterTests<ImmutablePersonImpl> {

    public PersonConstructorAndGetterTest() {
        super(ImmutablePersonImpl.class);
    }
}
