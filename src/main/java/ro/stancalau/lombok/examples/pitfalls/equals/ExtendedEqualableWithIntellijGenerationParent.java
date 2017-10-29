package ro.stancalau.lombok.examples.pitfalls.equals;

import lombok.Getter;
import lombok.Setter;
import ro.stancalau.lombok.examples.correct.CorrectEqualableParent;

@Getter
@Setter
//Missing @EqualsAndHashCode, but with manual implementation with missing cal to super.canEqual(this)
public class ExtendedEqualableWithIntellijGenerationParent extends CorrectEqualableParent {

    private int a = 0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ExtendedEqualableWithIntellijGenerationParent that = (ExtendedEqualableWithIntellijGenerationParent) o;

        return a == that.a;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + a;
        return result;
    }
}
