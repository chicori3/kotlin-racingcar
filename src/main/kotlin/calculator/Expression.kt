package calculator

import java.util.regex.MatchResult

class Expression(
    private val expression: String,
) {
    init {
        validate(expression)
    }

    fun extractNumbers(): List<Double> {
        return numberRegex()
            .matcher(expression)
            .results()
            .map(MatchResult::group)
            .map(String::toDouble)
            .toList()
    }

    fun extractOperators(): List<Operator> {
        return operatorRegex()
            .matcher(expression)
            .results()
            .map(MatchResult::group)
            .map(Operator::from)
            .toList()
    }

    private fun validate(expression: String) {
        val isValid =
            expressionRegex()
                .matcher(expression)
                .matches()

        require(isValid) { "올바른 수식이 아닙니다." }
    }
}
