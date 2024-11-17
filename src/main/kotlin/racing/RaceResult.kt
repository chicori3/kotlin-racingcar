package racing

class RaceResult {
    var roundCount: Int = 0
        get() = results.map(Result::round).distinct().size
        private set

    var carCount: Int = 0
        get() = results.map(Result::carId).distinct().size
        private set

    var winners: List<Result> = emptyList()
        get() = results.distinctBy(Result::carId).maxBy(Result::position).let(::listOf)
        private set

    private val results = mutableListOf<Result>()

    fun getWinnerNames(): List<String> {
        val maxPosition = results.maxOf(Result::position)

        return results.filter { it.position == maxPosition }
            .distinctBy(Result::carId)
            .map(Result::name)
    }

    fun add(result: Result) {
        results.add(result)
        roundCount += result.round
        carCount += result.carId
    }

    fun getResults(): List<Result> {
        return results.toList()
    }
}
