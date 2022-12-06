package day05

import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

class SupplyStacksTest {

    private val input = """
            [D]    
        [N] [C]    
        [Z] [M] [P]
        1   2   3 

        move 1 from 2 to 1
        move 3 from 1 to 3
        move 2 from 2 to 1
        move 1 from 1 to 2
    """.trimIndent()

    @Test
    fun `test get top crates on stack`() {
        separatePlanAndInstruction(input)
            .first
            .stackPlan()
            .getTopCrates() `should be equal to` listOf(Crate('N'), Crate('D'), Crate('P'))
    }

    @Test
    fun `test get top crates as string`() {
        separatePlanAndInstruction(input)
            .first
            .stackPlan()
            .getTopCrates()
            .foldToString() `should be equal to` "NDP"
    }

    @Test
    fun `test rearrange crates following the instructions`() {
        val input = separatePlanAndInstruction(input)
        input.first
            .stackPlan()
            .rearrangeCrates(input.second.instructions())
            .getTopCrates()
            .foldToString() `should be equal to` "CMZ"
    }

    @Test
    fun `test rearrange crates following the instructions with the CrateMover 9001`() {
        val input = separatePlanAndInstruction(input)
        input.first
            .stackPlan()
            .rearrangeCrates(input.second.instructions(), useCrateMover9001 = true)
            .getTopCrates()
            .foldToString() `should be equal to` "MCD"
    }
}