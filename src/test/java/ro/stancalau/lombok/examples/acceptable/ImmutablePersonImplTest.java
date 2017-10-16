package ro.stancalau.lombok.examples.acceptable;

import ro.stancalau.lombok.base.ImmutablePersonTest;

public class ImmutablePersonImplTest extends ImmutablePersonTest<ImmutablePersonImpl> {

    @Override
    public ImmutablePersonImpl createPerson(String name) {
        return new ImmutablePersonImpl(name);
    }

    @Override
    public ImmutablePersonImpl createPerson() {
        return new ImmutablePersonImpl();
    }
}