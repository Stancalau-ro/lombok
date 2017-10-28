package ro.stancalau.lombok.tests.person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ro.stancalau.lombok.api.ImmutablePerson;
import ro.stancalau.lombok.api.MutablePerson;
import ro.stancalau.lombok.tests.base.PersonBaseTest;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PersonConstructorAndGetterTests<T extends ImmutablePerson> extends PersonBaseTest<T> {

    public PersonConstructorAndGetterTests(Class<T> clazz) {
        super(clazz);
    }

    @Test
    public void givenPersonConstructedWithNoArgsWhenGetNameThenItIsDefault() throws Exception {
        //given
        ImmutablePerson person = create();

        //when
        String name = person.getName();

        //then
        assertEquals(MutablePerson.DEFAULT_NAME, name);
    }

    @Test(expected = NullPointerException.class)
    public void givenNullNameConstructingThenNullPointerExceptionExpected() throws Exception {
        //given
        String name = null;

        //when
        create(name);
    }
}
