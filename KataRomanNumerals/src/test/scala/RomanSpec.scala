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
    "2013" in{
      Roman(2013) === "MMXIII"
    }
  }

  "Roman numbers are converted back to normal for" >> {
    "I" in {
      Roman.toNormal("I") === 1
    }
    "V" in {
      Roman.toNormal("V") === 5
    }
    "IX" in {
      Roman.toNormal("IX") === 9
    }
    "MMVIII" in{
      Roman.toNormal("MMVIII") === 2008
    }
    "MCMXC" in {
      Roman.toNormal("MCMXC") === 1990
    }
    "MMXIII" in {
      Roman.toNormal("MMXIII") === 2013
    }
  }
}
