package ro.stancalau.lombok.goodpractice;

import ro.stancalau.lombok.api.Parent;
import ro.stancalau.lombok.api.ParentTest;
import ro.stancalau.lombok.api.Person;

import java.util.Set;

public class CorrectParentTest extends ParentTest {

    @Override
    public Parent createPerson(String name, Set<Person> children) {
        return new CorrectParent(name, children);
    }

    @Override
    public Parent createPerson(String name) {
        return new CorrectParent(name);
    }

    @Override
    public Parent createPerson() {
        return new CorrectParent();
    }
}