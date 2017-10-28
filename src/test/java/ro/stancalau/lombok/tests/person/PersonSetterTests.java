package ro.stancalau.lombok.tests.person;

import org.junit.Test;
import ro.stancalau.lombok.api.MutablePerson;
import ro.stancalau.lombok.tests.base.PersonBaseTest;

import static org.junit.Assert.assertEquals;
import static ro.stancalau.lombok.tests.base.TestNames.NAME;
import static ro.stancalau.lombok.tests.base.TestNames.NEW_NAME;

public abstract class PersonSetterTests<T extends MutablePerson> extends PersonBaseTest<T> {

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
