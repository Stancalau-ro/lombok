package ro.stancalau.lombok.examples.acceptable.immutable.parent;

import ro.stancalau.lombok.base.person.PersonConstructorsAndGettersTests;
import ro.stancalau.lombok.examples.acceptable.ImmutableParentImpl;

public class PersonConstructorsAndGettersTest extends PersonConstructorsAndGettersTests<ImmutableParentImpl> {

    public PersonConstructorsAndGettersTest() {
        super(ImmutableParentImpl.class);
    }
}
