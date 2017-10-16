package ro.stancalau.lombok.examples.pitfalls.exposure;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ro.stancalau.lombok.api.MutablePerson;

@Getter
@Setter
@RequiredArgsConstructor
public class PublicallyExposedNameMutablePerson implements MutablePerson {

    @NonNull
    public String name;

    public PublicallyExposedNameMutablePerson() {
        this(DEFAULT_NAME);
    }
}
