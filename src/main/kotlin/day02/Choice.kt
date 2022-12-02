package day02

sealed interface Choice {
    object Rock : Choice
    object Paper : Choice
    object Scissors : Choice
    object None : Choice
}
