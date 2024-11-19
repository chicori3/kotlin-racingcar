package racing.presentation

import racing.domain.CarFactory
import racing.domain.NumberGenerator
import racing.domain.RaceProcessor
import racing.domain.RaceResult
import racing.presentation.request.RaceRequest

class RaceController(
    private val raceProcessor: RaceProcessor,
    private val numberGenerator: NumberGenerator,
) {
    fun race(request: RaceRequest): RaceResult {
        val cars = CarFactory.createCarsWithNames(request.names, numberGenerator)
        val result =
            raceProcessor.execute(
                cars = cars,
                round = request.tryCount,
            )

        return result
    }
}
