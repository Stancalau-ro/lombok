package ro.stancalau.lombok.examples.goodpractice;

import ro.stancalau.lombok.base.PersonTest;

public class CorrectPersonTest extends PersonTest<CorrectPerson> {

    @Override
    public CorrectPerson createPerson(String name) {
        return new CorrectPerson(name);
    }

    @Override
    public CorrectPerson createPerson() {
        return new CorrectPerson();
    }
}