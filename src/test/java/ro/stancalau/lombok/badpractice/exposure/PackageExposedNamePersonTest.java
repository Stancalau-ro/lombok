package ro.stancalau.lombok.badpractice.exposure;

import ro.stancalau.lombok.api.PersonTest;

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