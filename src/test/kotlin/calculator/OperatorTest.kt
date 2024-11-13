package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OperatorTest : StringSpec({
    "덧셈 연산자는 덧셈을 수행한다" {
        val operator = Operator.PLUS

        val actual = operator.apply(1.0, 2.0)

        actual shouldBe 3.0
    }

    "뺄셈 연산자는 뺄셈을 수행한다" {
        val operator = Operator.MINUS

        val actual = operator.apply(1.0, 2.0)

        actual shouldBe -1.0
    }

    "곱셈 연산자는 곱셈을 수행한다" {
        val operator = Operator.MULTIPLY

        val actual = operator.apply(1.0, 2.0)

        actual shouldBe 2.0
    }

    "나눗셈 연산자는 나눗셈을 수행한다" {
        val operator = Operator.DIVIDE

        val actual = operator.apply(1.0, 2.0)

        actual shouldBe 0.5
    }

    "나눗셈 연산자는 0이 피연산자로 제공될 경우 IllegalArgumentException을 던진다" {
        val operator = Operator.DIVIDE

        shouldThrow<IllegalArgumentException> {
            operator.apply(1.0, 0.0)
        }
    }
})
