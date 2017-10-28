package ro.stancalau.lombok.examples.acceptable.immutable.person;

import ro.stancalau.lombok.examples.acceptable.ImmutablePersonImpl;
import ro.stancalau.lombok.tests.person.PersonBaseEqualsAndHashTests;

public class PersonBaseEqualsAndHashTest extends PersonBaseEqualsAndHashTests<ImmutablePersonImpl> {

    public PersonBaseEqualsAndHashTest() {
        super(ImmutablePersonImpl.class);
    }

}