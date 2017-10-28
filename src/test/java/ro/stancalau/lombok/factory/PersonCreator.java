package ro.stancalau.lombok.factory;

import ro.stancalau.lombok.api.ImmutablePerson;

public class PersonCreator<T extends ImmutablePerson> extends PersonReflectionFactory<T> {

    //FIXME why wre these here>?
    protected static final String NAME = "Joe";
    protected static final String NEW_NAME = "Jerome";

    public PersonCreator(Class<T> clazz) {
        super(clazz);
    }
}
