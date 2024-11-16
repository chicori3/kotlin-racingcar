package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class InputViewTest : StringSpec({
    "입력이 없으면 예외가 발생한다" {
        val inputView = ConsoleInputView()

        val exception =
            shouldThrow<IllegalArgumentException> {
                inputView.inputNumber(null)
            }

        exception.message shouldBe "입력이 없습니다."
    }

    "0 ~ 9 사이의 숫자가 아니면 예외가 발생한다" {
        val inputView = ConsoleInputView()

        val exception =
            shouldThrow<IllegalArgumentException> {
                inputView.inputNumber("a")
            }

        exception.message shouldBe "0 ~ 9 사이의 숫자만 입력 가능합니다."
    }
})
