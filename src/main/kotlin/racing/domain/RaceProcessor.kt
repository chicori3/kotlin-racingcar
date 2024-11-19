package racing.domain

class RaceProcessor {
    fun execute(
        cars: List<Car>,
        round: Int,
    ): RaceResult {
        validate(cars, round)

        return start(cars, round)
    }

    private fun start(
        cars: List<Car>,
        round: Int,
    ): RaceResult {
        return List(round) {
            cars.forEach(Car::move)
            Result(it + 1, cars)
        }.run {
            RaceResult(this)
        }
    }

    private fun validate(
        cars: List<Car>,
        round: Int,
    ) {
        require(cars.isNotEmpty()) { "차는 1대 이상이어야 합니다." }
        require(round > 0) { "라운드는 1 이상이어야 합니다." }
    }
}
