package ro.stancalau.lombok.tests.person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ro.stancalau.lombok.api.MutablePerson;
import ro.stancalau.lombok.tests.base.PersonBaseTest;
import ro.stancalau.lombok.tests.base.TestParam;

import static org.junit.Assert.assertEquals;
import static ro.stancalau.lombok.tests.base.TestNames.NAME;
import static ro.stancalau.lombok.tests.base.TestNames.NEW_NAME;

@RunWith(Parameterized.class)
public class PersonSetterTests<T extends MutablePerson> extends PersonBaseTest<T> {

    @SuppressWarnings("unchecked")
    public PersonSetterTests(TestParam param) {
        super((Class<T>) param.getClassUnderTest());
    }

    @Test
    public void givenPersonWhenSetNameThenGetUpdatedName() throws Exception {
        //given
        MutablePerson person = create(NAME);

        //when
        person.setName(NEW_NAME);

        //then
        assertEquals(NEW_NAME, person.getName());
    }
}
