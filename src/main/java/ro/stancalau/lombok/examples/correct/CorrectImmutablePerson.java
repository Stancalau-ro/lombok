package ro.stancalau.lombok.examples.correct;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import ro.stancalau.lombok.api.ImmutablePerson;

@Value
@RequiredArgsConstructor
public class CorrectImmutablePerson implements ImmutablePerson {

    @NonNull
    private String name;

    public CorrectImmutablePerson() {
        this(DEFAULT_NAME);
    }
}
