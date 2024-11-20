package racing.domain

object RaceProcessor {
    private const val INITIAL_ROUND = 1

    fun execute(
        cars: List<Car>,
        round: Int,
    ): RaceResult {
        validate(cars, round)
        return processRaceRounds(cars, round)
    }

    private fun processRaceRounds(
        cars: List<Car>,
        round: Int,
    ): RaceResult {
        val results =
            List(round) {
                cars.forEach(Car::move)
                Result.of(INITIAL_ROUND + it, cars)
            }
        return RaceResult(results)
    }

    private fun validate(
        cars: List<Car>,
        round: Int,
    ) {
        require(cars.isNotEmpty()) { "차는 1대 이상이어야 합니다." }
        require(round > 0) { "라운드는 1 이상이어야 합니다." }
    }
}
