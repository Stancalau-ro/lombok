package ro.stancalau.lombok.badpractice.exposure;

import ro.stancalau.lombok.api.PersonTest;

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