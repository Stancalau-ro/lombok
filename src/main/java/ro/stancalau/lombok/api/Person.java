package ro.stancalau.lombok.api;

public interface Person {

    String DEFAULT_NAME = "JohnDoe";

    String getName();

    void setName(String name);
}
