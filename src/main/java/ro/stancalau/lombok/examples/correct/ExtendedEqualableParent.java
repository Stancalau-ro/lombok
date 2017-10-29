package ro.stancalau.lombok.examples.correct;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ExtendedEqualableParent extends EqualableParent {
}
