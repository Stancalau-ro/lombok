package ro.stancalau.lombok.tests.person;

import org.junit.Test;
import ro.stancalau.lombok.api.ImmutablePerson;
import ro.stancalau.lombok.api.MutablePerson;
import ro.stancalau.lombok.tests.base.PersonBaseTest;

import java.lang.reflect.Modifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ro.stancalau.lombok.tests.base.TestNames.NAME;

public abstract class PersonConstructorAndGetterTests<T extends ImmutablePerson> extends PersonBaseTest<T> {

    public PersonConstructorAndGetterTests(Class<T> clazz) {
        super(clazz);
    }

    @Test
    public void givenPersonConstructedWithNoArgsWhenGetNameThenItIsDefault() throws Exception {
        //given
        T person = create();

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

    @Test
    public void givenPersonWhenCheckingModifiersOfNameFieldThenFieldIsDeclaredPrivate() throws Exception {
        //given
        T person = create(NAME);

        //when
        int nameModifiers = person.getClass().getDeclaredField("name").getModifiers();

        //then
        assertTrue(Modifier.isPrivate(nameModifiers));
    }
}
