package ro.stancalau.lombok.examples.acceptable;

public class EqualableParentEqualsHashTest
        extends EqualableParentIEqualsHashTest<EqualableParent, ExtendedEqualableParent> {

    @Override
    public EqualableParent createPerson(String name) {
        return new EqualableParent(name);
    }

    @Override
    public EqualableParent createPerson() {
        return new EqualableParent();
    }
}