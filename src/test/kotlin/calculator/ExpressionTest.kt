package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

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
