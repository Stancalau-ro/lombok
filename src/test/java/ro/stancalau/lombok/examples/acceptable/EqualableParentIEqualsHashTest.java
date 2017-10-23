package ro.stancalau.lombok.examples.acceptable;

import ro.stancalau.lombok.api.MutableParent;
import ro.stancalau.lombok.base.PersonBaseEqualsAndHashTest;

public abstract class EqualableParentIEqualsHashTest<P extends MutableParent, C extends P>
        extends PersonBaseEqualsAndHashTest<P> {

    //TODO add tests for non-transitivity between parent-child equals.

}
