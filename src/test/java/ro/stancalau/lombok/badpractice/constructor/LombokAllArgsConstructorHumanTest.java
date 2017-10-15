package ro.stancalau.lombok.badpractice.constructor;

import ro.stancalau.lombok.api.Human;
import ro.stancalau.lombok.api.HumanTest;

import java.util.Set;

public class LombokAllArgsConstructorHumanTest extends HumanTest {

    @Override
    protected Human createHuman(String name, Set<Human> children) {
        return new LombokAllArgsConstructorHuman(name, children);
    }

    @Override
    protected Human createHuman(String name) {
        return new LombokAllArgsConstructorHuman(name);
    }
}