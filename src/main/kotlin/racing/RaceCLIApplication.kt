package racing

import racing.infrastructure.RandomNumberGenerator
import racing.presentation.RaceController
import racing.presentation.request.RaceRequest
import racing.view.ConsoleInputView
import racing.view.ConsoleResultView

object RaceCLIApplication {
    private val inputView = ConsoleInputView()
    private val resultView = ConsoleResultView()
    private val numberGenerator = RandomNumberGenerator()
    private val raceController = RaceController(numberGenerator = numberGenerator)

    @JvmStatic
    fun main(args: Array<String>) {
        val names = setupNames()
        val tryCount = setUpTryCount()

        val request = RaceRequest(names, tryCount)
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
}
