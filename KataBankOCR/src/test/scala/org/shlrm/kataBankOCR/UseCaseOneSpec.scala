package org.shlrm.kataBankOCR

import org.specs2.mutable._
import io.Source

class UseCaseOneSpec extends Specification {
  "The file with the tests for usecase1" should {
    "compute out to the correct list of account numbers" in {
      val source = Source.fromURL(getClass.getResource("/usecase1.txt"))
      val parsed = FileParser.parse(source)
      Account.fromOCR(parsed).map(_.toString) must beEqualTo(
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
