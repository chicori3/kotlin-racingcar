package calculator

class StringCalculator : Calculator {
    override fun calculate(expression: Expression): Double {
        val numbers = expression.extractNumbers()
        val operators = expression.extractOperators()

        return operators.foldIndexed(numbers.first()) { index, acc, operator ->
            operator.apply(acc, numbers[index + 1])
        }
    }
}
