package ro.stancalau.lombok.goodpractice;

import ro.stancalau.lombok.api.Human;
import ro.stancalau.lombok.api.HumanTest;

import java.util.Set;

public class CorrectHumanTest extends HumanTest {

    @Override
    protected Human createHuman(String name, Set<Human> children) {
        return new CorrectHuman(name, children);
    }

    @Override
    protected Human createHuman(String name) {
        return new CorrectHuman(name);
    }
}