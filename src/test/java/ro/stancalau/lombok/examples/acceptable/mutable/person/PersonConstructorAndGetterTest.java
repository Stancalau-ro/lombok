package ro.stancalau.lombok.examples.acceptable.mutable.person;

import ro.stancalau.lombok.examples.acceptable.MutablePersonImpl;
import ro.stancalau.lombok.tests.person.PersonConstructorAndGetterTests;

public class PersonConstructorAndGetterTest extends PersonConstructorAndGetterTests<MutablePersonImpl> {

    public PersonConstructorAndGetterTest() {
        super(MutablePersonImpl.class);
    }
}
