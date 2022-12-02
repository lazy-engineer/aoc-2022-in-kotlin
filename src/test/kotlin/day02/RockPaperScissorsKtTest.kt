package day02

import org.amshove.kluent.`should be`
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

class RockPaperScissorsKtTest {

    private val input = """
      A Y
      B X
      C Z
    """.trimIndent()

    @Test
    fun `test match list by lines`() {
        matchList(input.lines()) `should be equal to` listOf(listOf("A", "Y"), listOf("B", "X"), listOf("C", "Z"))
    }

    @Test
    fun `test match list by lines size`() {
        matchList(input.lines()).size `should be` 3
    }

    @Test
    fun `calculate points with own mapping strategy`() {
        val mappingStrategy = MappingStrategy(
            rock = listOf("A", "X"),
            paper = listOf("B", "Y"),
            scissors = listOf("C", "Z"),
        )

        matchList(input.lines()).calculatePoints(mappingStrategy) `should be equal to` 15
    }

    @Test
    fun `calculate points with ultra top secret strategy`() {
        val matchOutcomeStrategy = MatchOutcomeStrategy(
            win = "Z",
            lose = "X",
            draw = "Y",
        )

        matchList(input.lines()).calculatePoints(matchOutcomeStrategy) `should be equal to` 12
    }
}
