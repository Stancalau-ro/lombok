package ro.stancalau.lombok.examples.acceptable;

import ro.stancalau.lombok.base.MutablePersonTest;

public class MutablePersonImplTest extends MutablePersonTest<MutablePersonImpl> {

    @Override
    public MutablePersonImpl createPerson(String name) {
        return new MutablePersonImpl(name);
    }

    @Override
    public MutablePersonImpl createPerson() {
        return new MutablePersonImpl();
    }
}