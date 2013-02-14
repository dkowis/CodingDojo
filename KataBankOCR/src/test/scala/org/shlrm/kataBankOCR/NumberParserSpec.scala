package org.shlrm.kataBankOCR

import org.specs2.mutable._
import io.Source
import org.specs2.specification.Scope

trait fileSetup extends Scope {
  lazy val source = Source.fromURL(getClass.getResource("/usecase1.txt"))
  lazy val parsed = FileParser.parse(source)
}

class NumberParserSpec extends Specification {
  "The file with the tests for usecase1" should {
    "provide 11 account numbers" in new fileSetup {
      parsed.size must beEqualTo(11)
      //Print them out to look at them, easy enough to verify by hand
      //parsed.foreach(x => {
      //  println(s"${x.foldLeft("")((a,b) => a + "\n" + b)}")
      //})
    }
    "compute out to the correct list of account numbers" in new fileSetup {
      Account.fromOCR(parsed).map(x => x.toString ) must beEqualTo(
        List(
          "000000000",
          "111111111",
          "222222222",
          "333333333",
          "444444444",
          "555555555",
          "666666666",
          "777777777",
          "888888888",
          "999999999",
          "123456789"
        )
      )
    }
  }
}
