package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.util.regex.MatchResult
import java.util.regex.Pattern

class ExpressionTest : StringSpec({
    "식이 빈 문자열이라면 IllegalArgumentException을 던진다" {
        val expression = ""

        shouldThrow<IllegalArgumentException> {
            Expression(expression)
        }
    }

    "식에 숫자가 아닌 문자가 포함되어 있다면 IllegalArgumentException을 던진다" {
        val expression = "1 + a"

        shouldThrow<IllegalArgumentException> {
            Expression(expression)
        }
    }

    "식에 사칙 연산자가 아닌 것이 포함되어 있다면 IllegalArgumentException을 던진다" {
        val expression = "1 ^ 2"

        shouldThrow<IllegalArgumentException> {
            Expression(expression)
        }
    }

    "식이 주어지면 숫자를 추출한다" {
        val expression = Expression("2 + 3 * 4 / 2")

        val actual = expression.extractNumbers()

        actual.size shouldBe 4
        actual[0] shouldBe 2.0
        actual[1] shouldBe 3.0
        actual[2] shouldBe 4.0
        actual[3] shouldBe 2.0
    }

    "식이 주어지면 연산자를 추출한다" {
        val expression = Expression("2 + 3 * 4 / 2")

        val actual = expression.extractOperators()

        actual.size shouldBe 3
        actual[0] shouldBe Operator.PLUS
        actual[1] shouldBe Operator.MULTIPLY
        actual[2] shouldBe Operator.DIVIDE
    }
})

class Expression(
    private val expression: String,
) {
    init {
        validate(expression)
    }

    fun extractNumbers(): List<Double> {
        return Pattern.compile("\\d+")
            .matcher(expression)
            .results()
            .map(MatchResult::group)
            .map(String::toDouble)
            .toList()
    }

    fun extractOperators(): List<Operator> {
        return Pattern.compile("[+\\-*/]")
            .matcher(expression)
            .results()
            .map(MatchResult::group)
            .map(::mapOperator)
            .toList()
    }

    private fun mapOperator(operator: String): Operator {
        return when (operator) {
            "+" -> Operator.PLUS
            "-" -> Operator.MINUS
            "*" -> Operator.MULTIPLY
            "/" -> Operator.DIVIDE
            else -> throw IllegalArgumentException("올바르지 않은 연산자입니다.")
        }
    }

    private fun validate(expression: String) {
        val pattern = Pattern.compile("^\\d+( [+\\-*/] \\d+)*$")
        val matcher = pattern.matcher(expression)
        val isValid = matcher.matches()

        require(isValid) { "올바른 수식이 아닙니다." }
    }
}

enum class Operator {
    PLUS {
        override fun apply(
            left: Double,
            right: Double,
        ): Double {
            return left + right
        }
    },

    MINUS {
        override fun apply(
            left: Double,
            right: Double,
        ): Double {
            return left - right
        }
    },

    MULTIPLY {
        override fun apply(
            left: Double,
            right: Double,
        ): Double {
            return left * right
        }
    },

    DIVIDE {
        override fun apply(
            left: Double,
            right: Double,
        ): Double {
            if (left == 0.0 || right == 0.0) {
                throw IllegalArgumentException("0으로 나눌 수 없습니다.")
            }

            return left / right
        }
    }, ;

    abstract fun apply(
        left: Double,
        right: Double,
    ): Double
}
