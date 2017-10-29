package ro.stancalau.lombok.examples.correct;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//Must also have @EqualsAndHashCode annotation to ensure symmetry of #equals method
@EqualsAndHashCode(callSuper = true)
public class ExtendedEqualableParent extends EqualableParent {
}
