package ro.stancalau.lombok.base.person;

import org.junit.Test;
import ro.stancalau.lombok.api.ImmutablePerson;
import ro.stancalau.lombok.api.MutablePerson;
import ro.stancalau.lombok.factory.PersonCreator;

import java.lang.reflect.Modifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class PersonConstructorsAndGettersTests<T extends ImmutablePerson> extends PersonCreator<T> {

    public PersonConstructorsAndGettersTests(Class<T> clazz) {
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
