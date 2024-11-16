package racing

class RaceResult {
    private var roundCount: Int = 0
        get() = results.map(Result::round).distinct().size

    private var carCount: Int = 0
        get() = results.map(Result::carId).distinct().size

    private val results = mutableListOf<Result>()

    fun add(result: Result) {
        results.add(result)
        roundCount += result.round
        carCount += result.carId
    }

    fun getResults(): List<Result> {
        return results.toList()
    }
}
