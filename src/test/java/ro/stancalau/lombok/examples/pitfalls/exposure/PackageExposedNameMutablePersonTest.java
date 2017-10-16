package ro.stancalau.lombok.examples.pitfalls.exposure;

import ro.stancalau.lombok.base.MutablePersonTest;

public class PackageExposedNameMutablePersonTest extends MutablePersonTest<PackageExposedNameMutablePerson> {

    @Override
    public PackageExposedNameMutablePerson createPerson(String name) {
        return new PackageExposedNameMutablePerson(name);
    }

    @Override
    public PackageExposedNameMutablePerson createPerson() {
        return new PackageExposedNameMutablePerson();
    }
}