package org.shlrm.kataBankOCR

import org.specs2.mutable._
import org.specs2.specification.Scope

class UseCaseTwoSpec extends Specification {
  "The parser" should {
    "know if an account number is valid" in {
      val parser = new NumberParser()
      parser.validAccount("457508000") must beTrue
    }
    "know if an account number is not valid" in {
      val parser = new NumberParser()
      parser.validAccount("664371495") must beFalse
    }
  }

}
