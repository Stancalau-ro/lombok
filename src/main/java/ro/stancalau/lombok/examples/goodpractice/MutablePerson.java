package ro.stancalau.lombok.examples.goodpractice;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ro.stancalau.lombok.api.Person;

@Getter
@Setter
@RequiredArgsConstructor
public class MutablePerson implements Person {

    @NonNull
    private String name;

    public MutablePerson() {
        this(DEFAULT_NAME);
    }
}
