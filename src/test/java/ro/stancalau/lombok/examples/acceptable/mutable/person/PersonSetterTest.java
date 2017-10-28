package ro.stancalau.lombok.examples.acceptable.mutable.person;

import ro.stancalau.lombok.examples.acceptable.MutablePersonImpl;
import ro.stancalau.lombok.tests.person.PersonSetterTests;

public class PersonSetterTest extends PersonSetterTests<MutablePersonImpl> {

    public PersonSetterTest() {
        super(MutablePersonImpl.class);
    }
}
