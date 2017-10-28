package ro.stancalau.lombok.examples.pitfalls.equals;

import lombok.Getter;
import lombok.Setter;
import ro.stancalau.lombok.examples.correct.EqualableParent;

@Getter
@Setter
//Missing @EqualsAndHashCode and no .equals/.hashCode override
public class ExtendedEqualableWithNoAnnotationParent extends EqualableParent {
}
