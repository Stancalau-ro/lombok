package ro.stancalau.lombok.examples.correct;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ro.stancalau.lombok.api.MutablePerson;

@Getter
@Setter
@RequiredArgsConstructor
public class CorrectMutablePerson implements MutablePerson {

    @NonNull
    private String name;

    public CorrectMutablePerson() {
        this(DEFAULT_NAME);
    }
}
