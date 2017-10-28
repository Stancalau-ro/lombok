package ro.stancalau.lombok.examples.pitfalls.exposure;

import ro.stancalau.lombok.tests.person.PersonSetterTests;

public class PackageExposedNameMutablePersonTest extends PersonSetterTests<PackageExposedNameMutablePerson> {


    public PackageExposedNameMutablePersonTest(Class<PackageExposedNameMutablePerson> clazz) {
        super(clazz);
    }

    public PackageExposedNameMutablePerson create(String name) {
        return new PackageExposedNameMutablePerson(name);
    }

    public PackageExposedNameMutablePerson create() {
        return new PackageExposedNameMutablePerson();
    }
}