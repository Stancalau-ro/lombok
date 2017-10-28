package ro.stancalau.lombok.examples.acceptable;

import ro.stancalau.lombok.api.MutableParent;
import ro.stancalau.lombok.base.person.PersonBaseEqualsAndHashTests;

public abstract class EqualableParentIEqualsHashTest<P extends MutableParent, C extends P>
        extends PersonBaseEqualsAndHashTests<P> {

    public EqualableParentIEqualsHashTest(Class<P> clazz) {
        super(clazz);
    }

    //TODO add tests for non-transitivity between parent-child equals.

}
