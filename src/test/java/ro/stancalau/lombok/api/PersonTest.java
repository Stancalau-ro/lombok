package ro.stancalau.lombok.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class PersonTest<T extends Person> implements PersonFactory<T> {

    protected static final String NAME = "Joe";
    protected static final String NEW_NAME = "Jerome";

    @Test
    public void givenPersonConstructedWithNoArgsWhenGetNameThenItIsDefault() throws Exception {
        //given
        Person joe = createPerson();

        //when
        String name = joe.getName();

        //then
        assertEquals(Person.DEFAULT_NAME, name);
    }

    @Test
    public void givenPersonWhenSetNameThenGetUpdatedName() throws Exception {
        //given
        Person joe = createPerson(NAME);

        //when
        joe.setName(NEW_NAME);

        //then
        assertEquals(NEW_NAME, joe.getName());
    }
}
