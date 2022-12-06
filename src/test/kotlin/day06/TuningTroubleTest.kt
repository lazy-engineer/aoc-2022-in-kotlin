package day06

import org.amshove.kluent.`should be`
import org.junit.jupiter.api.Test

class TuningTroubleTest {

    @Test
    fun `test find 4 char marker`() {
        findMarker("bvwbjplbgvbhsrlpgdmjqwftvncz", 4) `should be` 5
        findMarker("nppdvjthqldpwncqszvftbrmjlhg", 4) `should be` 6
        findMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 4) `should be` 10
        findMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 4) `should be` 11
    }

    @Test
    fun `test find 14 char marker`() {
        findMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 14) `should be` 19
        findMarker("bvwbjplbgvbhsrlpgdmjqwftvncz", 14) `should be` 23
        findMarker("nppdvjthqldpwncqszvftbrmjlhg", 14) `should be` 23
        findMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 14) `should be` 29
        findMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 14) `should be` 26
    }
}