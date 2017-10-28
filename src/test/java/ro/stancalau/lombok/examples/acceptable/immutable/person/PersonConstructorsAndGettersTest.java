package ro.stancalau.lombok.examples.acceptable.immutable.person;

import ro.stancalau.lombok.base.person.PersonConstructorsAndGettersTests;
import ro.stancalau.lombok.examples.acceptable.ImmutablePersonImpl;

public class PersonConstructorsAndGettersTest extends PersonConstructorsAndGettersTests<ImmutablePersonImpl> {

    public PersonConstructorsAndGettersTest() {
        super(ImmutablePersonImpl.class);
    }
}
