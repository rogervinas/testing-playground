[![CI](https://github.com/rogervinas/testing-playground/actions/workflows/gradle.yml/badge.svg)](https://github.com/rogervinas/testing-playground/actions/workflows/gradle.yml)

# Testing Playground

## Mutation Testing

[Mutation Testing](mutation-testing/src/test/kotlin/org/testingplayground/MyImplTest.kt) using [pitest](https://pitest.org/)

> Mutation testing is conceptually quite simple.
> Faults (or mutations) are automatically seeded into your code, then your tests are run. If your tests fail then the mutation is killed, if your tests pass then the mutation lived.
> The quality of your tests can be gauged from the percentage of mutations killed.

## Property-based Testing

[Property-based Testing](property-based-testing/src/test/kotlin/PropertyBasedTesting.kt) using [Kotest](https://kotest.io/docs/proptest/property-based-testing.html)

> Instead of writing example-based tests, with property testing,
> hundreds or thousands of values are fed into the same test,
> and the values are (usually) randomly generated by your property test framework

## Snapshot Testing

[Snapshot Testing](snapshot-testing/src/test/kotlin/SnapshotTesting.kt) using [origin-energy/java-snapshot-testing](https://github.com/origin-energy/java-snapshot-testing)

> **Advantages of Snapshot Testing**
> * Great for testing JSON interfaces ensuring you don't break clients
> * Fast and easy to test
> * Will implicitly test areas of your code you did not think about
> * Great of testing dynamic objects
>
> **Disadvantages of Snapshot Testing**
> * You need to ensure your test is deterministic for all fields
> * Does not give great insight to why the snapshot failed
> * Can be difficult to troll though large snapshot changes where you might only be interested in a small set of fields
