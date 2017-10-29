package ro.stancalau.lombok.tests.base;

import static org.junit.Assert.assertTrue;

public class EqualableTestParam extends TestParam {

    private final Class childClass;

    @SuppressWarnings("unchecked")
    public EqualableTestParam(Class parentClass, Class childClass) {
        super(parentClass);
        assertTrue("Child class does not appear to extend parent class.", parentClass.isAssignableFrom(childClass));

        this.childClass = childClass;
    }

    public Class getChildClass() {
        return childClass;
    }
}
