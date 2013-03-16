import org.specs2.mutable._

class RomanSpec extends Specification {
  "Numbers are converted correctly to roman numerals for" >> {
    "1" in {
      Roman(1) === "I"
    }
    "9" in {
      Roman(9) === "IX"
    }
    "10" in {
      Roman(10) === "X"
    }
    "1990" in {
      Roman(1990) === "MCMXC"
    }
    "2008" in {
      Roman(2008) === "MMVIII"
    }
  }
}
