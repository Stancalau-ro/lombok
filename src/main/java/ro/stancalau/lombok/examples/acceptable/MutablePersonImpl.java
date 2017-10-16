package ro.stancalau.lombok.examples.acceptable;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ro.stancalau.lombok.api.MutablePerson;

@Getter
@Setter
@RequiredArgsConstructor
public class MutablePersonImpl implements MutablePerson {

    @NonNull
    private String name;

    public MutablePersonImpl() {
        this(DEFAULT_NAME);
    }
}
