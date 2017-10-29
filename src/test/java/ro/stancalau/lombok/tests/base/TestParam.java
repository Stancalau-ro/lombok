package ro.stancalau.lombok.tests.base;

public class TestParam {

    private final Class clazz;

    public TestParam(Class clazz) {
        this.clazz = clazz;
    }

    public Class getClassUnderTest() {
        return clazz;
    }

    @Override
    public String toString() {
        return getClassUnderTest().getName();
    }
}
