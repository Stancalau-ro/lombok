package ro.stancalau.lombok.examples.acceptable;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import ro.stancalau.lombok.api.ImmutablePerson;

@Value
@RequiredArgsConstructor
public class ImmutablePersonImpl implements ImmutablePerson {

    @NonNull
    private String name;

    public ImmutablePersonImpl() {
        this(DEFAULT_NAME);
    }
}
