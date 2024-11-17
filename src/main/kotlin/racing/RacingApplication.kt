package racing

object RacingApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        val inputView = ConsoleInputView()
        val resultView = ConsoleResultView()
        val carFactory = CarFactory
        val raceProcessor = RaceProcessor
        val generator = RandomNumberGenerator()

        val names = setupNames(inputView)
        val tryCount = setUpTryCount(inputView)

        val cars = carFactory.createCarsWithNames(names, generator)
        val result = raceProcessor.execute(cars, tryCount)

        resultView.showResult(result)
    }

    private fun setupNames(inputView: InputView): List<String> {
        inputView.askNames()
        return inputView.inputNames(readlnOrNull())
    }

    private fun setUpTryCount(inputView: InputView): Int {
        inputView.askTryCount()
        return inputView.inputNumber(readlnOrNull())
    }
}
