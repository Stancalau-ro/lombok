package ro.stancalau.lombok.examples.acceptable;

import ro.stancalau.lombok.base.person.PersonSetterTests;

public class MutablePersonImplTest extends PersonSetterTests<MutablePersonImpl> {

    public MutablePersonImplTest(Class<MutablePersonImpl> clazz) {
        super(clazz);
    }

    public MutablePersonImpl create(String name) {
        return new MutablePersonImpl(name);
    }

    public MutablePersonImpl create() {
        return new MutablePersonImpl();
    }
}