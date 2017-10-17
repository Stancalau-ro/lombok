package ro.stancalau.lombok.base;

import org.junit.Before;
import org.junit.Test;
import ro.stancalau.lombok.api.ImmutablePerson;

import static org.junit.Assert.*;

public abstract class PersonBaseEqualsAndHashTest<T extends ImmutablePerson> implements PersonFactory<T> {

    private T person;
    private T samePerson;
    private T sameClone;
    private T stranger;

    @Before
    public void setUp() throws Exception {
        person = createPerson();
        samePerson = createPerson();
        sameClone = createPerson();
        stranger = createPerson("Stranger");
    }

    @Test
    public void testNotEqualsToNull() throws Exception {
        assertFalse(person.equals(null));
    }

    @Test
    public void testReflexive() throws Exception {
        assertTrue(person.equals(person));
    }

    @Test
    public void testSymmetric() throws Exception {
        assertFalse(person.equals(stranger));
        assertFalse(stranger.equals(person));

        assertTrue(person.equals(samePerson));
        assertTrue(samePerson.equals(person));
    }

    @Test
    public void testTransitive() throws Exception {
        assertTrue(person.equals(samePerson));
        assertTrue(samePerson.equals(sameClone));
        assertTrue(sameClone.equals(person));
    }

    @Test
    public void givenPersonsWithSameStateWhenCompareHashCodesThenAreEqual() throws Exception {
        assertEquals(person.hashCode(), samePerson.hashCode());
    }
}
