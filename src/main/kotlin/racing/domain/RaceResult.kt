package racing.domain

data class RaceResult(
    val results: List<Result>,
) {
    fun getWinnerNames(): List<String> {
        val lastResult = results.maxByOrNull(Result::round) ?: return emptyList()

        return lastResult.getWinnerNames()
    }
}
