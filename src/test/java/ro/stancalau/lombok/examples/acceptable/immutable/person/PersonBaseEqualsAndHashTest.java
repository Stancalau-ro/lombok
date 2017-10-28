package ro.stancalau.lombok.examples.acceptable.immutable.person;

import ro.stancalau.lombok.base.person.PersonBaseEqualsAndHashTests;
import ro.stancalau.lombok.examples.acceptable.ImmutablePersonImpl;

public class PersonBaseEqualsAndHashTest extends PersonBaseEqualsAndHashTests<ImmutablePersonImpl> {

    public PersonBaseEqualsAndHashTest() {
        super(ImmutablePersonImpl.class);
    }

}