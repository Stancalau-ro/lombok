package ro.stancalau.lombok.tests.base;

import ro.stancalau.lombok.api.ImmutableParent;
import ro.stancalau.lombok.factory.ParentFactory;

public interface ParentTest<T extends ImmutableParent> extends PersonTest<T>, ParentFactory<T> {
}
