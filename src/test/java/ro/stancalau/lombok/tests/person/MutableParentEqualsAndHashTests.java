package ro.stancalau.lombok.tests.person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ro.stancalau.lombok.api.MutableParent;
import ro.stancalau.lombok.tests.base.PersonBaseTest;
import ro.stancalau.lombok.tests.base.TestParam;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static ro.stancalau.lombok.tests.base.TestNames.NEW_NAME;

@RunWith(Parameterized.class)
public class MutableParentEqualsAndHashTests<T extends MutableParent> extends PersonBaseTest<T> {

    public MutableParentEqualsAndHashTests(TestParam param) {
        super((Class<T>) param.getClassUnderTest());
    }

    @Test
    public void givenTwoEquivalentParentsWhenAChildIsAddedToOneThenTheyAreNoLongerEqual() throws Exception {
        //given
        MutableParent parent = create();
        MutableParent equivalentParent = create();

        assertEquals(parent, equivalentParent);
        assertEquals(parent.hashCode(), equivalentParent.hashCode());

        //when
        equivalentParent.addChild(create());

        //then
        assertNotEquals(parent, equivalentParent);
    }

    @Test
    public void givenTwoEquivalentParentsWhenAChildIsAddedToOneThenHashCodesNoLongerEqual() throws Exception {
        //given
        MutableParent parent = create();
        MutableParent equivalentParent = create();

        assertEquals(parent, equivalentParent);
        assertEquals(parent.hashCode(), equivalentParent.hashCode());

        //when
        equivalentParent.addChild(create());

        //then
        assertNotEquals(parent.hashCode(), equivalentParent.hashCode());
    }

    @Test
    public void givenTwoEquivalentParentsWhenOneHasNameChangedTheyAreNoLongerEqual() throws Exception {
        //given
        MutableParent parent = create();
        MutableParent equivalentParent = create();

        assertEquals(parent, equivalentParent);
        assertEquals(parent.hashCode(), equivalentParent.hashCode());

        //when
        equivalentParent.setName(NEW_NAME);

        //then
        assertNotEquals(parent, equivalentParent);
    }

    @Test
    public void givenTwoEquivalentParentsWhenOneHasNameChangedTheyHashCodesNoLongerEqual() throws Exception {
        //given
        MutableParent parent = create();
        MutableParent equivalentParent = create();

        assertEquals(parent, equivalentParent);
        assertEquals(parent.hashCode(), equivalentParent.hashCode());

        //when
        equivalentParent.setName(NEW_NAME);

        //then
        assertNotEquals(parent.hashCode(), equivalentParent.hashCode());
    }

    @Test
    public void givenTwoEquivalentParentsWhenAChildIsAddedToBothThenTheyAreStillEqual() throws Exception {
        //given
        MutableParent parent = create();
        MutableParent equivalentParent = create();

        assertEquals(parent, equivalentParent);
        assertEquals(parent.hashCode(), equivalentParent.hashCode());

        //when
        MutableParent child = create();
        parent.addChild(child);
        equivalentParent.addChild(child);

        //then
        assertEquals(parent, equivalentParent);
        assertEquals(parent.hashCode(), equivalentParent.hashCode());
    }
}
