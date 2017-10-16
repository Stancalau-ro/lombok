package ro.stancalau.lombok.examples.pitfalls.exposure;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ro.stancalau.lombok.api.MutablePerson;

@Getter
@Setter
@RequiredArgsConstructor
public class PackageExposedNameMutablePerson implements MutablePerson {

    @NonNull
    String name;

    public PackageExposedNameMutablePerson() {
        this(DEFAULT_NAME);
    }
}
