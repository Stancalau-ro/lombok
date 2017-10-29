# Lombok Pitfalls and Correct Approaches
Examples for Lombok good practices and common pitfalls.

## Prerequisites

1. JDK 8
2. Gradle or IDE gradle support 
3. Lombok plugin over your IDE

## Pitfalls 

### Constructors
- Side-effects possible using `@RequiredArgsConstructor` and `@AllArgsConstructor` generated constructors over mutable fields.
- Null initialization using `@NoArgsConstructor`  

### Equals and HashCode
- Symmetry of `equals` method broken when not all classes in hierarchy use `@EqualsAndHashCode`

### Exposure
- Multiple ways of accessing object state when using `@Getter/@Setter` over non-private fields.

### Getters
- Actual field reference returned using `@Getter`. Side-effects possible when field type is mutable.

### Setters
- Actual parameter reference set using `@Setter`. Side-effects possible when field type is mutable.

### Immutable Value
- Actual field reference returned using `@Value`. Side-effects possible when field type is mutable.
- Actual parameter reference set using `@Value`. Side-effects possible when field type is mutable.

## Notes
 :collision: All tests in `ro.stancalau.examples.pitfalls` package are meant to fail in order to exemplify common pitfalls.

## References

[Lombok Project home page](https://projectlombok.org/)

[Gradle home page](https://gradle.org/)

