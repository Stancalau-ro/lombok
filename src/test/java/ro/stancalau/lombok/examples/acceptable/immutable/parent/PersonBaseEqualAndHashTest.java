package ro.stancalau.lombok.examples.acceptable.immutable.parent;

import ro.stancalau.lombok.examples.acceptable.ImmutableParentImpl;
import ro.stancalau.lombok.tests.person.PersonBaseEqualsAndHashTests;

public class PersonBaseEqualAndHashTest extends PersonBaseEqualsAndHashTests<ImmutableParentImpl> {

    public PersonBaseEqualAndHashTest() {
        super(ImmutableParentImpl.class);
    }

}