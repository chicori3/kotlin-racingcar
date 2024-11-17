package racing

class ConsoleResultView : ResultView {
    override fun showResult(result: RaceResult) {
        println(MESSAGE)

        result.getResults()
            .groupBy(Result::round)
            .forEach { (_, results) -> renderResults(results) }

        printWinners(result)
    }

    private fun renderResults(results: List<Result>) {
        results.forEach(::printResult)
        println()
    }

    private fun printResult(result: Result) {
        println("${result.name} : ${MARK.repeat(result.position)}")
    }

    private fun printWinners(result: RaceResult) {
        val winnerNames = result.getWinnerNames().joinToString(", ")
        println("$winnerNames 가 최종 우승했습니다.")
    }

    companion object {
        const val MESSAGE = "실행 결과"
        const val MARK = "-"
    }
}
