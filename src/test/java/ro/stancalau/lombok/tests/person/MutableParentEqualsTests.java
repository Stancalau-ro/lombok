package ro.stancalau.lombok.tests.person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ro.stancalau.lombok.api.MutableParent;
import ro.stancalau.lombok.tests.base.PersonBaseTest;
import ro.stancalau.lombok.tests.base.TestParam;

import static org.junit.Assert.*;
import static ro.stancalau.lombok.tests.base.TestNames.NEW_NAME;

@RunWith(Parameterized.class)
public class MutableParentEqualsTests<T extends MutableParent> extends PersonBaseTest<T> {

    public MutableParentEqualsTests(TestParam param) {
        super((Class<T>) param.getClassUnderTest());
    }

    @Test
    public void givenTwoEquivalentParentsWhenAChildIsAddedToOneThenTheyAreNoLongerEqual() throws Exception {
        //given
        MutableParent parent = create();
        MutableParent equivalentParent = create();

        assertEquals(parent, equivalentParent);

        //when
        equivalentParent.addChild(create());

        //then
        assertFalse(parent.equals(equivalentParent));
    }

    @Test
    public void givenTwoEquivalentParentsWhenOneHasNameChangedTheyAreNoLongerEqual() throws Exception {
        //given
        MutableParent parent = create();
        MutableParent equivalentParent = create();

        assertEquals(parent, equivalentParent);

        //when
        equivalentParent.setName(NEW_NAME);

        //then
        assertFalse(parent.equals(equivalentParent));
    }

    @Test
    public void givenTwoEquivalentParentsWhenAChildIsAddedToBothThenTheyAreStillEqual() throws Exception {
        //given
        MutableParent parent = create();
        MutableParent equivalentParent = create();

        assertEquals(parent, equivalentParent);

        //when
        MutableParent child = create();
        parent.addChild(child);
        equivalentParent.addChild(child);

        //then
        assertTrue(parent.equals(equivalentParent));
    }
}
