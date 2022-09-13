package org.testingplayground

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class MyImplTest {

    // https://pitest.org/

    // Mutation testing is conceptually quite simple.
    // Faults (or mutations) are automatically seeded into your code, then your tests are run.
    // If your tests fail then the mutation is killed, if your tests pass then the mutation lived.
    //
    // The quality of your tests can be gauged from the percentage of mutations killed.

    // ./gradlew mutation-testing:clean mutation-testing:test mutation-testing:pitest

    private val myImpl = MyImpl()

    @ParameterizedTest
    @CsvSource(
        value = [
            "0, 0, Both A and B are zero"
        ]
    )
    fun `should do something`(a: Int, b: Int, expectedResult: String) {
        assertThat(myImpl.doSomething(a, b)).isEqualTo(expectedResult)
    }
}