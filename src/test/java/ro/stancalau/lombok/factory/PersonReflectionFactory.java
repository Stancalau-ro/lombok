package ro.stancalau.lombok.factory;

import lombok.SneakyThrows;
import ro.stancalau.lombok.api.ImmutablePerson;

import java.lang.reflect.InvocationTargetException;

public class PersonReflectionFactory<T extends ImmutablePerson> implements PersonFactory<T> {

    protected final Class<T> clazz;

    public PersonReflectionFactory(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    @SneakyThrows
    public T create(String name) {
        try {
            return (T) Class.forName(clazz.getName()).getConstructor(String.class).newInstance((String) name);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }

    @Override
    @SneakyThrows
    public T create() {
        return create(ImmutablePerson.DEFAULT_NAME);
    }

}
