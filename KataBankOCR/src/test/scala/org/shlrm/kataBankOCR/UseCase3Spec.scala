package org.shlrm.kataBankOCR

import org.specs2.mutable.Specification
import io.Source
import org.specs2.execute.StandardResults

class UseCase3Spec extends Specification {
  "The file with the tests for usecase3" should {
    "produce a list of findings" in {
      val source = Source.fromURL(getClass.getResource("/usecase3.txt"))
      val parsed = FileParser.parse(source)
      Account.fromOCR(parsed).map(x => s"${x.toString} ${x.status}") must beEqualTo(
        List(
          "457508000 ",
          "664371495 ERR",
          "86110??36 ILL"
        )
      )
    }
  }

}
