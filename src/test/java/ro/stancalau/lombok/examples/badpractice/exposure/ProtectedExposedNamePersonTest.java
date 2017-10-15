package ro.stancalau.lombok.examples.badpractice.exposure;

import ro.stancalau.lombok.base.PersonTest;

public class ProtectedExposedNamePersonTest extends PersonTest<ProtectedExposedNamePerson> {

    @Override
    public ProtectedExposedNamePerson createPerson(String name) {
        return new ProtectedExposedNamePerson(name);
    }

    @Override
    public ProtectedExposedNamePerson createPerson() {
        return new ProtectedExposedNamePerson();
    }
}