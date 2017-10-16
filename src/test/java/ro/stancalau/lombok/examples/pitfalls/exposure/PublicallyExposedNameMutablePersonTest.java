package ro.stancalau.lombok.examples.pitfalls.exposure;

import ro.stancalau.lombok.base.MutablePersonTest;

public class PublicallyExposedNameMutablePersonTest extends MutablePersonTest<PublicallyExposedNameMutablePerson> {

    @Override
    public PublicallyExposedNameMutablePerson createPerson(String name) {
        return new PublicallyExposedNameMutablePerson(name);
    }

    @Override
    public PublicallyExposedNameMutablePerson createPerson() {
        return new PublicallyExposedNameMutablePerson();
    }
}