package ro.stancalau.lombok.examples.badpractice.exposure;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ro.stancalau.lombok.api.Person;

@Getter
@Setter
@RequiredArgsConstructor
public class PublicallyExposedNamePerson implements Person {

    @NonNull
    public String name;

    public PublicallyExposedNamePerson() {
        this(DEFAULT_NAME);
    }
}
