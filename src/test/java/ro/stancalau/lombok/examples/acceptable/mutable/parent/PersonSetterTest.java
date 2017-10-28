package ro.stancalau.lombok.examples.acceptable.mutable.parent;

import ro.stancalau.lombok.examples.acceptable.MutableParentImpl;
import ro.stancalau.lombok.tests.person.PersonSetterTests;

public class PersonSetterTest extends PersonSetterTests<MutableParentImpl> {

    public PersonSetterTest() {
        super(MutableParentImpl.class);
    }
}
