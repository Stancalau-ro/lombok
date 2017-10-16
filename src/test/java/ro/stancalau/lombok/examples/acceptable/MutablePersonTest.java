package ro.stancalau.lombok.examples.acceptable;

import ro.stancalau.lombok.base.PersonTest;

public class MutablePersonTest extends PersonTest<MutablePerson> {

    @Override
    public MutablePerson createPerson(String name) {
        return new MutablePerson(name);
    }

    @Override
    public MutablePerson createPerson() {
        return new MutablePerson();
    }
}