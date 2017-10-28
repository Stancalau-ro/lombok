package ro.stancalau.lombok.examples.acceptable.immutable.parent;

import ro.stancalau.lombok.base.person.PersonBaseEqualsAndHashTests;
import ro.stancalau.lombok.examples.acceptable.ImmutableParentImpl;

public class PersonBaseEqualAndHashTest extends PersonBaseEqualsAndHashTests<ImmutableParentImpl> {

    public PersonBaseEqualAndHashTest() {
        super(ImmutableParentImpl.class);
    }

}