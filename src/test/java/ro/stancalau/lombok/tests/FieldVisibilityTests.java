package ro.stancalau.lombok.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ro.stancalau.lombok.api.ImmutablePerson;
import ro.stancalau.lombok.tests.base.PersonBaseTest;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertTrue;
import static ro.stancalau.lombok.tests.base.TestNames.NAME;

@RunWith(Parameterized.class)
public class FieldVisibilityTests<T extends ImmutablePerson> extends PersonBaseTest<T> {

    public FieldVisibilityTests(Class<T> clazz) {
        super(clazz);
    }

    @Test
    public void givenImmutableTypeWhenGetAllFieldsThenAllFieldsAreFinalAndPrivate() throws Exception {
        //given
        ImmutablePerson person = create();

        //when
        Field[] fields = person.getClass().getFields();

        //then
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
                //There may be constants defined
                continue;
            }
            assertTrue(field.getName() + " is not private", Modifier.isPrivate(modifiers));
            assertTrue(field.getName() + " is not final", Modifier.isFinal(modifiers));
        }
    }

    @Test
    public void givenPersonWhenCheckingModifiersOfNameFieldThenFieldIsDeclaredPrivate() throws Exception {
        //given
        ImmutablePerson person = create(NAME);

        //when
        int nameModifiers = person.getClass().getDeclaredField("name").getModifiers();

        //then
        assertTrue(Modifier.isPrivate(nameModifiers));
    }
}
