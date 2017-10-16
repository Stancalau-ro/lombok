package ro.stancalau.lombok.base;

import org.junit.Before;
import org.junit.Test;
import ro.stancalau.lombok.api.ImmutablePerson;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class PersonBaseEqualsAndHashTest<T extends ImmutablePerson> implements PersonFactory<T> {

    private T person;
    private T samePerson;
    private T stranger;

    @Before
    public void setUp() throws Exception {
        person = createPerson();
        samePerson = createPerson();
        stranger = createPerson("Stranger");
    }

    @Test
    public void testNotEqualsToNull() throws Exception {
        assertFalse(person.equals(null));
    }

    @Test
    public void testEqualsToSelf() throws Exception {
        assertTrue(person.equals(person));
        assertTrue(stranger.equals(stranger));
    }

    @Test
    public void givenTwoPeopleWithDifferentNameWhenEqualsThenReturnFalse() throws Exception {
        assertFalse(person.equals(stranger));
        assertFalse(stranger.equals(person));
    }

    @Test
    public void givenPersonWithSameStateWhenEqualsThenReturnTrue() throws Exception {
        assertTrue(person.equals(samePerson));
    }

    //TODO add more tests for equals and hash

}
