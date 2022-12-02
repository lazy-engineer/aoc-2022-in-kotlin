package day02

import day02.Choice.*

interface MatchStrategy {
    fun apply(choice: Pair<String, String>): Pair<Choice, Choice>
}

data class MappingStrategy(
    val rock: List<String>,
    val paper: List<String>,
    val scissors: List<String>,
) : MatchStrategy {

    override fun apply(choice: Pair<String, String>): Pair<Choice, Choice> {
        val opponentsChoice = when {
            rock.contains(choice.first) -> Rock
            paper.contains(choice.first) -> Paper
            scissors.contains(choice.first) -> Scissors
            else -> None
        }

        val myChoice = when {
            rock.contains(choice.second) -> Rock
            paper.contains(choice.second) -> Paper
            scissors.contains(choice.second) -> Scissors
            else -> None
        }

        return opponentsChoice to myChoice
    }
}

data class MatchOutcomeStrategy(
    val win: String,
    val lose: String,
    val draw: String,
) : MatchStrategy {

    override fun apply(choice: Pair<String, String>): Pair<Choice, Choice> {

        return when (choice.first) {
            "A" -> {
                when {
                    win == choice.second -> Rock to Paper
                    lose == choice.second -> Rock to Scissors
                    draw == choice.second -> Rock to Rock
                    else -> None to None
                }
            }

            "B" -> {
                when {
                    win == choice.second -> Paper to Scissors
                    lose == choice.second -> Paper to Rock
                    draw == choice.second -> Paper to Paper
                    else -> None to None
                }
            }

            "C" -> {
                when {
                    win == choice.second -> Scissors to Rock
                    lose == choice.second -> Scissors to Paper
                    draw == choice.second -> Scissors to Scissors
                    else -> None to None
                }
            }

            else -> None to None
        }
    }
}
