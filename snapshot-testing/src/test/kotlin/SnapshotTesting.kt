import au.com.origin.snapshots.Expect
import au.com.origin.snapshots.junit5.SnapshotExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.time.Clock
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import kotlin.random.Random

// https://github.com/origin-energy/java-snapshot-testing

// Advantages of Snapshot Testing
// * Great for testing JSON interfaces ensuring you don't break clients
// * Fast and easy to test
// * Will implicitly test areas of your code you did not think about
// * Great of testing dynamic objects

// Disadvantages of Snapshot Testing
// * You need to ensure your test is deterministic for all fields
// * Does not give great insight to why the snapshot failed
// * Can be difficult to troll though large snapshot changes where you might only be interested in a small set of fields

@ExtendWith(SnapshotExtension::class)
class SnapshotTesting {

    private val myImpl = MyImpl(12345, Clock.fixed(Instant.ofEpochSecond(1662563313), ZoneId.of("UTC")))

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
    fun `should do something`(input: Int, expect: Expect) {
        val myResult = myImpl.doSomething(input)
        expect
            .scenario("$input")
            .serializer("orderedJson")
            .toMatchSnapshot(myResult)
    }

    @Test
    fun `should do something more`(expect: Expect) {
        val myResult = myImpl.doSomethingMore()
        expect.serializer("orderedJson").toMatchSnapshot(myResult)
    }
}

class MyImpl(randomSeed: Int, private val clock: Clock) {

    private val random = Random(randomSeed)

    fun doSomething(input: Int) = MyResult(
        oneInteger = input,
        oneDouble = 3.7 * input,
        oneString = "a".repeat(input),
        oneDateTime = LocalDateTime.of(
            LocalDate.of(2022, 5, 3),
            LocalTime.of(13, 46, 18)
        )
    )

    fun doSomethingMore() = MyResult(
        oneInteger = random.nextInt(),
        oneDouble = random.nextDouble(),
        oneString = "a".repeat(random.nextInt(10)),
        oneDateTime = LocalDateTime.now(clock)
    )
}

data class MyResult(
    val oneInteger: Int,
    val oneDouble: Double,
    val oneString: String,
    val oneDateTime: LocalDateTime
)
