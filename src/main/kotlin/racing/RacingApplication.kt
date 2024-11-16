package racing

object RacingApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        val inputView = ConsoleInputView()
        val resultView = ConsoleResultView()
        val carFactory = CarFactory
        val raceProcessor = RaceProcessor
        val generator = RandomCountGenerator()

        val carCount = setUpCarQuantity(inputView)
        val tryCount = setUpTryCount(inputView)

        val cars = carFactory.createCars(carCount, generator)
        val result = raceProcessor.execute(cars, tryCount)

        resultView.showResult(result)
    }

    private fun setUpCarQuantity(inputView: InputView): Int {
        inputView.askCarCount()
        return inputView.inputCount(readlnOrNull())
    }

    private fun setUpTryCount(inputView: InputView): Int {
        inputView.askTryCount()
        return inputView.inputCount(readlnOrNull())
    }
}
