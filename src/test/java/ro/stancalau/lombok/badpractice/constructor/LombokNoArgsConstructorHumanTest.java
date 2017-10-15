package ro.stancalau.lombok.badpractice.constructor;


import ro.stancalau.lombok.api.Human;
import ro.stancalau.lombok.api.HumanTest;

import java.util.Set;

public class LombokNoArgsConstructorHumanTest extends HumanTest {

    @Override
    protected Human createHuman(String name, Set<Human> children) {
        return new LombokNoArgsConstructorHuman(name, children);
    }

    @Override
    protected Human createHuman(String name) {
        return new LombokNoArgsConstructorHuman();
    }
}