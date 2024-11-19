package racing.infrastructure

import racing.domain.RaceResult
import racing.domain.Result
import racing.domain.ResultView

class ConsoleResultView : ResultView {
    override fun showResult(result: RaceResult) {
        println(MESSAGE)

        result.results
            .sortedBy(Result::round)
            .forEach(::printResult)

        printWinners(result)
    }

    private fun printResult(result: Result) {
        result.cars.forEach {
            println("${it.name}: ${MARK.repeat(it.getPosition())}")
        }
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
