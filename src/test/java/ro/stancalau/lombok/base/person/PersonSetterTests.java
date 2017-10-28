package ro.stancalau.lombok.base.person;

import org.junit.Test;
import ro.stancalau.lombok.api.MutablePerson;
import ro.stancalau.lombok.factory.PersonCreator;

import static org.junit.Assert.assertEquals;

public abstract class PersonSetterTests<T extends MutablePerson> extends PersonCreator<T> {

    public PersonSetterTests(Class<T> clazz) {
        super(clazz);
    }

    @Test
    public void givenPersonWhenSetNameThenGetUpdatedName() throws Exception {
        //given
        T person = create(NAME);

        //when
        person.setName(NEW_NAME);

        //then
        assertEquals(NEW_NAME, person.getName());
    }
}
