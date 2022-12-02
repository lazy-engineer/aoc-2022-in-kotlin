package day02

sealed interface MatchResult {
    data class Win(val choiceBonus: Int) : MatchResult
    data class Lost(val choiceBonus: Int) : MatchResult
    data class Draw(val choiceBonus: Int) : MatchResult
    object None : MatchResult
}
