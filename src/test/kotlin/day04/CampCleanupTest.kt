package day04

import org.amshove.kluent.`should be`
import org.junit.jupiter.api.Test

class CampCleanupTest {

    private val input = """
        2-4,6-8
        2-3,4-5
        5-7,7-9
        2-8,3-7
        6-6,4-6
        2-6,4-8
    """.trimIndent()

    @Test
    fun `test count section overlaps`() {
        duosSectionOverlaps(input.lines().assignSections()) `should be` 2
    }

    @Test
    fun `test count overlapping duos`() {
        duosOverlaps(input.lines().assignSections()) `should be` 4
    }
}
