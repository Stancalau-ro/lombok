package ro.stancalau.lombok.base;

import org.junit.Test;
import ro.stancalau.lombok.api.Person;

import java.lang.reflect.Modifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class PersonTest<T extends Person> implements PersonFactory<T> {

    protected static final String NAME = "Joe";
    protected static final String NEW_NAME = "Jerome";

    @Test
    public void givenPersonConstructedWithNoArgsWhenGetNameThenItIsDefault() throws Exception {
        //given
        T joe = createPerson();

        //when
        String name = joe.getName();

        //then
        assertEquals(Person.DEFAULT_NAME, name);
    }

    @Test
    public void givenPersonWhenSetNameThenGetUpdatedName() throws Exception {
        //given
        T joe = createPerson(NAME);

        //when
        joe.setName(NEW_NAME);

        //then
        assertEquals(NEW_NAME, joe.getName());
    }

    @Test(expected = NullPointerException.class)
    public void givenNullNameConstructingThenNullPointerExceptionExpected() throws Exception {
        //given
        String name = null;

        //when
        createPerson(name);
    }

    @Test
    public void givenPersonWhenWhenCheckingModifiersOfNameFieldThenFieldIsDeclaredPrivate() throws Exception {
        //given
        T joe = createPerson(NAME);

        //when
        int nameModifiers = joe.getClass().getDeclaredField("name").getModifiers();

        //then
        assertTrue(Modifier.isPrivate(nameModifiers));
    }
}
