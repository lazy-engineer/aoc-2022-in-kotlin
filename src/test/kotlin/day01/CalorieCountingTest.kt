package day01

import org.amshove.kluent.`should be`
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

class CalorieCountingTest {

    private val input = """
        1000
        2000
        3000
        
        4000
        
        5000
        6000
        
        7000
        8000
        9000
        
        10000
    """.trimIndent()

    @Test
    fun `test calorie bags sum`() {
        calorieBags(input) `should be equal to` listOf(6000, 4000, 11000, 24000, 10000)
    }

    @Test
    fun `test calorie bags size`() {
        calorieBags(input).size `should be` 5
    }

    @Test
    fun `test elve with biggest bag`() {
        elveWithBiggestBag(calorieBags(input)) `should be equal to` 24000
    }

    @Test
    fun `test sum of top 3 elves with biggest bag`() {
        topThreeElves(calorieBags(input)) `should be equal to` 45000
    }
}