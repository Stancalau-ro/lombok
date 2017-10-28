package ro.stancalau.lombok.examples.pitfalls.exposure;

import ro.stancalau.lombok.tests.person.PersonSetterTests;

public class PublicallyExposedNameMutablePersonTest extends PersonSetterTests<PublicallyExposedNameMutablePerson> {


    public PublicallyExposedNameMutablePersonTest(Class<PublicallyExposedNameMutablePerson> clazz) {
        super(clazz);
    }

    public PublicallyExposedNameMutablePerson create(String name) {
        return new PublicallyExposedNameMutablePerson(name);
    }


    public PublicallyExposedNameMutablePerson create() {
        return new PublicallyExposedNameMutablePerson();
    }
}