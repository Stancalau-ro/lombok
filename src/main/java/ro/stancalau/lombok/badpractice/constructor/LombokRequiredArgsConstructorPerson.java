package ro.stancalau.lombok.badpractice.constructor;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ro.stancalau.lombok.api.Person;

import java.util.HashSet;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public class LombokRequiredArgsConstructorPerson implements Person {

    @NonNull
    private String name;
    @NonNull
    private Set<Person> children;

    public LombokRequiredArgsConstructorPerson() {
        this(DEFAULT_NAME);
    }

    public LombokRequiredArgsConstructorPerson(@NotNull String name) {
        this(name, new HashSet<>());
    }

    @Override
    //Implemented manually because Lombok returns reference to field itself, not copy nor unmodifiable wrapper
    public Set<Person> getChildren() {
        return new HashSet<>(children);
    }

    @Override
    public void addChild(@NonNull Person child) {
        children.add(child);
    }
}
