package ro.stancalau.lombok.base;

import org.junit.Test;
import ro.stancalau.lombok.api.ImmutablePerson;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertTrue;

public abstract class ImmutablePersonTest<T extends ImmutablePerson> extends PersonTest<T> {

    @Test
    public void givenImmutableTypeWhenGetAllFieldsThenAllFieldsAreFinalAndPrivate() throws Exception {
        //given
        T person = createPerson();

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
}
