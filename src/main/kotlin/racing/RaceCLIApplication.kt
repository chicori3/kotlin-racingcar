package racing

import racing.domain.RaceProcessor
import racing.infrastructure.ConsoleInputView
import racing.infrastructure.ConsoleResultView
import racing.infrastructure.RandomNumberGenerator
import racing.presentation.RaceController
import racing.presentation.request.RaceRequest

object RaceCLIApplication {
    private val inputView = ConsoleInputView()
    private val resultView = ConsoleResultView()
    private val numberGenerator = RandomNumberGenerator()
    private val raceProcessor = RaceProcessor()
    private val raceController =
        RaceController(
            raceProcessor = raceProcessor,
            numberGenerator = numberGenerator,
        )

    @JvmStatic
    fun main(args: Array<String>) {
        val names = setupNames()
        val tryCount = setUpTryCount()

        val request = toRequest(names, tryCount)
        val result = raceController.race(request)

        resultView.showResult(result)
    }

    private fun setupNames(): List<String> {
        inputView.askNames()
        return inputView.inputNames(readlnOrNull())
    }

    private fun setUpTryCount(): Int {
        inputView.askTryCount()
        return inputView.inputNumber(readlnOrNull())
    }

    private fun toRequest(
        names: List<String>,
        tryCount: Int,
    ): RaceRequest {
        return RaceRequest(names, tryCount)
    }
}
