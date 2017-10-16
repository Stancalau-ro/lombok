package ro.stancalau.lombok.examples.pitfalls.exposure;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ro.stancalau.lombok.api.MutablePerson;

@Getter
@Setter
@RequiredArgsConstructor
public class ProtectedExposedNameMutablePerson implements MutablePerson {

    @NonNull
    protected String name;

    public ProtectedExposedNameMutablePerson() {
        this(DEFAULT_NAME);
    }
}
