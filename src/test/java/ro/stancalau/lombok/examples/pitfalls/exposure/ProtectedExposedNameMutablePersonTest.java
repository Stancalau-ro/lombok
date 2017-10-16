package ro.stancalau.lombok.examples.pitfalls.exposure;

import ro.stancalau.lombok.base.MutablePersonTest;

public class ProtectedExposedNameMutablePersonTest extends MutablePersonTest<ProtectedExposedNameMutablePerson> {

    @Override
    public ProtectedExposedNameMutablePerson createPerson(String name) {
        return new ProtectedExposedNameMutablePerson(name);
    }

    @Override
    public ProtectedExposedNameMutablePerson createPerson() {
        return new ProtectedExposedNameMutablePerson();
    }
}