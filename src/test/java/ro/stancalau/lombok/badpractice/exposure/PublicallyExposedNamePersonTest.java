package ro.stancalau.lombok.badpractice.exposure;

import ro.stancalau.lombok.api.PersonTest;

public class PublicallyExposedNamePersonTest extends PersonTest<PublicallyExposedNamePerson> {

    @Override
    public PublicallyExposedNamePerson createPerson(String name) {
        return new PublicallyExposedNamePerson(name);
    }

    @Override
    public PublicallyExposedNamePerson createPerson() {
        return new PublicallyExposedNamePerson();
    }
}