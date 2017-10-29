package ro.stancalau.lombok.factory;

import lombok.SneakyThrows;
import ro.stancalau.lombok.api.ImmutableParent;
import ro.stancalau.lombok.api.MutablePerson;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ParentReflectionFactory<T extends ImmutableParent> extends PersonReflectionFactory<T> implements ParentFactory<T> {

    public ParentReflectionFactory(Class<T> clazz) {
        super(clazz);
    }

    @SuppressWarnings("unchecked")
    @Override
    @SneakyThrows
    public T create(String name, Set<MutablePerson> children) {
        try {
            return (T) Class.forName(clazz.getName()).getConstructor(String.class, Set.class).newInstance(name, children);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }
}
