import au.com.origin.snapshots.Expect
import au.com.origin.snapshots.junit5.SnapshotExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
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

    private val myImpl = MyImpl()

    @Test
    fun `should do something`(expect: Expect) {
        // TODO use json serializer
        // TODO use @ParameterizedTest
        val myResult = myImpl.doSomething(7)
        expect.toMatchSnapshot(myResult)
    }

    @Test
    fun `should do something more`(expect: Expect) {
        val myResult = myImpl.doSomethingMore()
        expect.toMatchSnapshot(myResult)
    }
}

class MyImpl {

    private val random = Random.Default

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
        oneDateTime = LocalDateTime.now()
    )
}

data class MyResult(
    val oneInteger: Int,
    val oneDouble: Double,
    val oneString: String,
    val oneDateTime: LocalDateTime
)
