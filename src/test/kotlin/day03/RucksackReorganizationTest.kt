package day03

import org.amshove.kluent.`should be`
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File

class RucksackReorganizationTest {

    private val input = """
        vJrwpWtwJgWrhcsFMMfFFhFp
        jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
        PmmdzqPrVvPwwTWBwg
        wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
        ttgJtRGJQctTZtZT
        CrZsJsPPZsGzwwsLwLmpwMDw
    """.trimIndent()

    private lateinit var testFile: File

    @BeforeEach
    fun setup() {
        testFile = File("test.txt")
        testFile.writeText(input)
    }

    @Test
    fun `test rucksack list by lines`() {
        rucksackList(testFile) `should be equal to` listOf(
            Rucksack("vJrwpWtwJgWrhcsFMMfFFhFp"),
            Rucksack("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"),
            Rucksack("PmmdzqPrVvPwwTWBwg"),
            Rucksack("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn"),
            Rucksack("ttgJtRGJQctTZtZT"),
            Rucksack("CrZsJsPPZsGzwwsLwLmpwMDw")
        )
    }

    @Test
    fun `test rucksack list size`() {
        rucksackList(testFile).size `should be` 6
    }

    @Test
    fun `test rucksack compartments`() {
        rucksackList(testFile)
            .first()
            .compartments(2) `should be equal to` listOf(
            Compartment("vJrwpWtwJgWr".associate { it to it.toPriority() }),
            Compartment("hcsFMMfFFhFp".associate { it to it.toPriority() })
        )
    }

    @Test
    fun `test item in both rucksack compartments`() {
        rucksackList(testFile)
            .first()
            .compartments(2)
            .getDuplicate() `should be equal to` ('p' to 'p'.toPriority())
    }

    @Test
    fun `test find item in first group`() {
        val testFile = File("test.txt")
        testFile.writeText(
            """
                vJrwpWtwJgWrhcsFMMfFFhFp
                jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
                PmmdzqPrVvPwwTWBwg
            """.trimIndent()
        )

        val compartments = rucksackList(testFile)[0].compartments(1)
            .plus(rucksackList(testFile)[1].compartments(1))
            .plus(rucksackList(testFile)[2].compartments(1))

        compartments
            .getDuplicate() `should be equal to` ('r' to 'r'.toPriority())
    }

    @Test
    fun `test find item in second group`() {
        val testFile = File("test.txt")
        testFile.writeText(
            """
                wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
                ttgJtRGJQctTZtZT
                CrZsJsPPZsGzwwsLwLmpwMDw
            """.trimIndent()
        )

        val compartments = rucksackList(testFile)[0].compartments(1)
            .plus(rucksackList(testFile)[1].compartments(1))
            .plus(rucksackList(testFile)[2].compartments(1))

        compartments
            .getDuplicate() `should be equal to` ('Z' to 'Z'.toPriority())
    }

    @Test
    fun `test find item in group`() {
        val testFile = File("test.txt")
        testFile.writeText(
            """
                DsPhSBQQQhqmBDhPDsFwjwsLjlRjlttvjvvtRb
                rNJMNNbrHrtjHLHjvwtg
                fNbNzZdrZnMnMPnQShFPDmnqFm
            """.trimIndent()
        )

        val compartments = rucksackList(testFile)[0].compartments(1)
            .plus(rucksackList(testFile)[1].compartments(1))
            .plus(rucksackList(testFile)[2].compartments(1))

        compartments
            .getDuplicate() `should be equal to` ('b' to 'b'.toPriority())
    }

    @Test
    fun `test priority of groups`() {
        val groups = rucksackList(testFile)
            .groupedRucksackCompartments(3)

        val groupResult = groups.sumOf { compartments ->
            compartments.getDuplicate().second
        }

        groupResult `should be` 70
    }

    @Test
    fun `test item priority`() {
        'a'.toPriority() `should be` 1
        'z'.toPriority() `should be` 26
        'A'.toPriority() `should be` 27
        'Z'.toPriority() `should be` 52
    }
}
