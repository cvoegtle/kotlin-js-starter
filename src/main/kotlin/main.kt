import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLSpanElement
import kotlin.browser.document

fun main(args: Array<String>) {
  Calculator().run()
}

class Calculator() {
  val inputA = getInputField("a")
  val inputB = getInputField("b")
  val resultField = document.getElementById("result") as HTMLSpanElement

  private fun recalc() {
    try {
      val result = calculate(inputA.value.toDouble(), inputB.value.toDouble())
      resultField.innerText = result.toString()
    } catch (ex: Exception) {
      resultField.innerText = "n/a"
    }
  }

  fun run() {
    inputA.focus()
  }

  private fun getInputField(name: String): HTMLInputElement {
    val input = document.getElementById(name) as HTMLInputElement
    input.onkeyup = { _ -> recalc() }
    return input
  }

  private fun calculate(a: Double, b: Double): Double {
    return a + b
  }

}

