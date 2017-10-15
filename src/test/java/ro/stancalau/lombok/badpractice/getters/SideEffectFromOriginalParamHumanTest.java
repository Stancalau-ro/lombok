package ro.stancalau.lombok.badpractice.getters;

import ro.stancalau.lombok.api.Human;
import ro.stancalau.lombok.api.HumanTest;

import java.util.Set;

public class SideEffectFromOriginalParamHumanTest extends HumanTest {

    @Override
    protected Human createHuman(String name, Set<Human> children) {
        return new SideEffectFromOriginalParamHuman(name, children);
    }

    @Override
    protected Human createHuman(String name) {
        return new SideEffectFromOriginalParamHuman(name);
    }
}
