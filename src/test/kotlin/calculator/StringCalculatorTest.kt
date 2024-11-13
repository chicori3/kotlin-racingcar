package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({
    val sut = StringCalculator()

    val expressions =
        listOf(
            Pair("2 + 3 * 4 / 2", 10.0),
            Pair("2 * 3 + 4 / 2", 5.0),
            Pair("2 + 3 * 4 - 2", 18.0),
            Pair("2 * 3 + 4 - 2", 8.0),
            Pair("2 + 3 * 4 + 2", 22.0),
        )

    "식을 계산한다" {
        expressions.forEach { (expression, expected) ->
            val actual = sut.calculate(Expression(expression))

            actual shouldBe expected
        }
    }
})

interface Calculator {
    fun calculate(expression: Expression): Double
}

class StringCalculator : Calculator {
    override fun calculate(expression: Expression): Double {
        val numbers = expression.extractNumbers()
        val operators = expression.extractOperators()

        return operators.foldIndexed(numbers.first()) { index, acc, operator ->
            operator.apply(acc, numbers[index + 1])
        }
    }
}
