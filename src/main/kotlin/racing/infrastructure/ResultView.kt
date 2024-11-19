package racing.infrastructure

import racing.domain.RaceResult

fun interface ResultView {
    fun showResult(result: RaceResult)
}
