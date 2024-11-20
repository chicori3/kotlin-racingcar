package racing.domain

data class RaceResult(
    val results: List<Result>,
) {
    private val lastResult: Result = results.maxBy(Result::round)

    fun getWinnerNames(): List<String> = lastResult.getWinnerNames()
}
