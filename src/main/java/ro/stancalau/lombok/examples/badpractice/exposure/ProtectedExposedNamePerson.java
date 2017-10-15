package ro.stancalau.lombok.examples.badpractice.exposure;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ro.stancalau.lombok.api.Person;

@Getter
@Setter
@RequiredArgsConstructor
public class ProtectedExposedNamePerson implements Person {

    @NonNull
    protected String name;

    public ProtectedExposedNamePerson() {
        this(DEFAULT_NAME);
    }
}
