package ro.stancalau.lombok.examples.badpractice.exposure;

import ro.stancalau.lombok.base.PersonTest;

public class PackageExposedNamePersonTest extends PersonTest<PackageExposedNamePerson> {

    @Override
    public PackageExposedNamePerson createPerson(String name) {
        return new PackageExposedNamePerson(name);
    }

    @Override
    public PackageExposedNamePerson createPerson() {
        return new PackageExposedNamePerson();
    }
}