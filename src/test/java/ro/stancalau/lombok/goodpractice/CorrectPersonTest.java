package ro.stancalau.lombok.goodpractice;

import ro.stancalau.lombok.api.PersonTest;

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