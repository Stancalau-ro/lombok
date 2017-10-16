package ro.stancalau.lombok.base;

import org.junit.Test;
import ro.stancalau.lombok.api.MutablePerson;

import static org.junit.Assert.assertEquals;

public abstract class MutablePersonTest<T extends MutablePerson> extends PersonTest<T> {

    @Test
    public void givenPersonWhenSetNameThenGetUpdatedName() throws Exception {
        //given
        T person = createPerson(NAME);

        //when
        person.setName(NEW_NAME);

        //then
        assertEquals(NEW_NAME, person.getName());
    }
}
