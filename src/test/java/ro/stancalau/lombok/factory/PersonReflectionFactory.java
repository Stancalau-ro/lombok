package ro.stancalau.lombok.factory;

import lombok.SneakyThrows;
import ro.stancalau.lombok.api.ImmutablePerson;

import java.lang.reflect.InvocationTargetException;

public class PersonReflectionFactory<T extends ImmutablePerson> implements PersonFactory<T> {

    protected final Class<T> clazz;

    public PersonReflectionFactory(Class<T> clazz) {
        this.clazz = clazz;
    }

    @SuppressWarnings("unchecked")
    @Override
    @SneakyThrows
    public T create(String name) {
        try {
            return (T) Class.forName(clazz.getName()).getConstructor(String.class).newInstance((String) name);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    @SneakyThrows
    public T create() {
        try {
            return (T) Class.forName(clazz.getName()).getConstructor().newInstance();
        } catch (NoSuchMethodException e) {
            return create(ImmutablePerson.DEFAULT_NAME);
        }
    }

}
