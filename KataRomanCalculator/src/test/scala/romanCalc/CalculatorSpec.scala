package romanCalc

import org.specs2.mutable._

class CalculatorSpec extends Specification {
  "The roman numeral calculator adds" >> {
    "I + I to get II" in {
      Calculator.calc("I + I") === "II"
    }
    "IV + XX to get XXIV" in {
      Calculator.calc("IV + XX") === "XXIV"
    }
    "XX + XX to get XL" in {
      Calculator.calc("XX + XX") === "XL"
    }
  }

}
