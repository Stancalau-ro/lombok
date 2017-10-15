package ro.stancalau.lombok.badpractice.exposure;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ro.stancalau.lombok.api.Person;

@Getter
@Setter
@RequiredArgsConstructor
public class PackageExposedNamePerson implements Person {

    @NonNull
    String name;

    public PackageExposedNamePerson() {
        this(DEFAULT_NAME);
    }
}
