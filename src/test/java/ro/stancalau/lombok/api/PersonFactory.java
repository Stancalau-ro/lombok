package ro.stancalau.lombok.api;

public interface PersonFactory<T extends Person> {

    T createPerson(String name);

    T createPerson();
}
