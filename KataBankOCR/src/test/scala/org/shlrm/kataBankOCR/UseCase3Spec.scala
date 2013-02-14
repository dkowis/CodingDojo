package org.shlrm.kataBankOCR

import org.specs2.mutable.Specification
import io.Source
import org.specs2.execute.StandardResults

class UseCase3Spec extends Specification {
  "The file with the tests for usecase3" should {
    "produce a list of findings" in {
      val source = Source.fromURL(getClass.getResource("/usecase3.txt"))
      val parsed = FileParser.parse(source)
      Account.fromOCR(parsed).map(_.report) must beEqualTo(
        List(
          "000000051",
          "49006771? ILL",
          "1234?678? ILL"
        )
      )
    }
  }

  "An illegal account" should {
    "not have a valid checksum" in {
      Account("1234?678?").valid must beFalse
    }
  }

}
