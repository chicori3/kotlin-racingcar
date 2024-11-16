package racing

object RaceProcessor {
    fun execute(
        cars: List<Car>,
        round: Int,
    ): RaceResult {
        validate(cars, round)

        val result = start(cars, round)

        return result
    }

    private fun start(
        cars: List<Car>,
        round: Int,
    ): RaceResult {
        val raceResult = RaceResult()

        repeat(round) { currentRound ->
            cars.forEach { car ->
                car.move()
                val result =
                    Result.from(
                        round = currentRound,
                        car = car,
                    )
                raceResult.add(result)
            }
        }

        return raceResult
    }

    private fun validate(
        cars: List<Car>,
        round: Int,
    ) {
        require(cars.isNotEmpty()) { "차는 1대 이상이어야 합니다." }
        require(round > 0) { "라운드는 1 이상이어야 합니다." }
    }
}
