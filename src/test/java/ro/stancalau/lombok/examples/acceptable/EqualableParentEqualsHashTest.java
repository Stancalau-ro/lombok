package ro.stancalau.lombok.examples.acceptable;

public class EqualableParentEqualsHashTest
        extends EqualableParentIEqualsHashTest<EqualableParent, ExtendedEqualableParent> {

    public EqualableParentEqualsHashTest(Class<EqualableParent> clazz) {
        super(clazz);
    }

    @Override
    public EqualableParent create(String name) {
        return new EqualableParent(name);
    }

    @Override
    public EqualableParent create() {
        return new EqualableParent();
    }
}