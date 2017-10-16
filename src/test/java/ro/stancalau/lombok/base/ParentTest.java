package ro.stancalau.lombok.base;

import org.junit.Before;
import org.junit.Test;
import ro.stancalau.lombok.api.Parent;
import ro.stancalau.lombok.api.Person;
import ro.stancalau.lombok.examples.acceptable.MutableParent;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public abstract class ParentTest extends PersonTest<Parent> implements ParentFactory<Parent> {

    private static final String BOY_NAME = "Joel";
    private static final String GIRL_NAME = "Jane";
    private static final Person ILLEGITIMATE_CHILD = new MutableParent("Bob");

    private Set<Person> globalChildren;

    @Before
    public void setUp() throws Exception {
        globalChildren = new HashSet<>();
        globalChildren.add(new MutableParent(BOY_NAME));
        globalChildren.add(new MutableParent(GIRL_NAME));
    }

    @Test
    public void givenValuesWhenConstructingParentThenGettersReturnOriginalValues() throws Exception {
        //when
        Parent parent = createPerson(NAME, globalChildren);

        //then
        assertEquals(NAME, parent.getName());
        assertEquals(2, parent.getChildren().size());
        assertEquals(globalChildren, parent.getChildren());
    }

    @Test
    public void givenParentWhenMutatingChildListAsSideEffectThenParentStateDoesNotChange() throws Exception {
        //given
        Parent parent = createPerson(NAME, globalChildren);

        //when
        parent.getChildren().add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, parent.getChildren().size());
        assertEquals(globalChildren, parent.getChildren());
    }

    @Test
    public void givenParentWhenMutatingChildListAsSideEffectThenGlobalSetDoesNotChange() throws Exception {
        //given
        Parent parent = createPerson(NAME, globalChildren);

        //when
        parent.getChildren().add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, globalChildren.size());
    }

    @Test
    public void givenParentWhenMutatingGlobalSetThenParentChildrenDoNotChange() throws Exception {
        //given
        Parent parent = createPerson(NAME, globalChildren);

        //when
        globalChildren.add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, parent.getChildren().size());
    }

    @Test
    public void givenParentWhenAddingChildThenChildCountIncreases() throws Exception {
        //given
        Parent parent = createPerson(NAME, globalChildren);

        //when
        parent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(3, parent.getChildren().size());
    }

    @Test
    public void givenParentWhenAddingChildThenNewChildIsContainedInChildren() throws Exception {
        //given
        Parent parent = createPerson(NAME, globalChildren);

        //when
        parent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertTrue(parent.getChildren().contains(ILLEGITIMATE_CHILD));
    }

    @Test
    public void givenParentWhenAddingChildThenGlobalSetSizeDoesNotChange() throws Exception {
        //given
        Parent parent = createPerson(NAME, globalChildren);

        //when
        parent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(2, globalChildren.size());
    }

    @Test
    public void givenParentWhenAddingChildThenNewChildNotContainedInGlobalSet() throws Exception {
        //given
        Parent parent = createPerson(NAME, globalChildren);

        //when
        parent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertFalse(globalChildren.contains(ILLEGITIMATE_CHILD));
    }

    @Test(expected = NullPointerException.class)
    public void givenNullChildrenSetWhenConstructingThenNullPointerExceptionExpected() throws Exception {
        //given
        Set<Person> children = null;

        //when
        createPerson(NAME, children);
    }

    @Test(expected = NullPointerException.class)
    public void givenNullNameConstructingThenNullPointerExceptionExpected() throws Exception {
        //given
        String name = null;

        //when
        createPerson(name, globalChildren);
    }

    @Test
    public void givenOnlyNameWhenConstructingThenChildrenSetSizeIsZero() throws Exception {
        //when
        Parent parent = createPerson(NAME);

        //then
        assertEquals(0, parent.getChildren().size());
    }

    @Test
    public void givenParentConstructedByNameWhenAddChildThenChildCountIncreases() throws Exception {
        //given
        Parent parent = createPerson(NAME);

        //when
        parent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(1, parent.getChildren().size());
    }

    @Test
    public void givenNoParamsWhenConstructThenChildrenSetSizeIsZero() throws Exception {
        //when
        Parent parent = createPerson();

        //then
        assertEquals(0, parent.getChildren().size());
    }

    @Test
    public void givenParentConstructedWithNoArgsWhenAddChildThenChildCountIncreases() throws Exception {
        //given
        Parent parent = createPerson();

        //when
        parent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(1, parent.getChildren().size());
    }

    @Test
    public void givenParentWhenSetChildrenThenGetUpdatedChildrenSet() throws Exception {
        //given
        Parent parent = createPerson(NAME, globalChildren);

        //when
        Set<Person> newChildren = Collections.singleton(createPerson(NEW_NAME));
        parent.setChildren(newChildren);

        //then
        assertEquals(newChildren, parent.getChildren());
    }

    @Test
    public void givenParentWithSetChildrenWhenOriginalSetChangesThenParentChildrenDoNotChange() throws Exception {
        //given
        Parent parent = createPerson(NAME);
        Set<Person> newChildren = new HashSet<>();
        parent.setChildren(newChildren);
        int childCount = newChildren.size();

        //when
        newChildren.add(ILLEGITIMATE_CHILD);

        //then
        assertEquals(childCount, parent.getChildren().size());
        assertFalse(parent.getChildren().contains(ILLEGITIMATE_CHILD));
    }

    @Test
    public void givenParentWithSetChildrenWhenParentChildAddedThenOriginalSetNotChanged() throws Exception {
        //given
        Parent parent = createPerson(NAME);
        Set<Person> newChildren = new HashSet<>();
        parent.setChildren(newChildren);
        int childCount = newChildren.size();

        //when
        parent.addChild(ILLEGITIMATE_CHILD);

        //then
        assertEquals(childCount, newChildren.size());
        assertFalse(newChildren.contains(ILLEGITIMATE_CHILD));
    }
}
