package ro.stancalau.lombok.examples.pitfalls.exposure;

import ro.stancalau.lombok.base.person.PersonSetterTests;

public class ProtectedExposedNameMutablePersonTest extends PersonSetterTests<ProtectedExposedNameMutablePerson> {


    public ProtectedExposedNameMutablePersonTest(Class<ProtectedExposedNameMutablePerson> clazz) {
        super(clazz);
    }

    public ProtectedExposedNameMutablePerson create(String name) {
        return new ProtectedExposedNameMutablePerson(name);
    }


    public ProtectedExposedNameMutablePerson create() {
        return new ProtectedExposedNameMutablePerson();
    }
}