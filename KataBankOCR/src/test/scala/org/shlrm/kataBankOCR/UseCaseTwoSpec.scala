package org.shlrm.kataBankOCR

import org.specs2.mutable._

class UseCaseTwoSpec extends Specification {
  "The parser" should {
    "know if an account number is valid" in {
      Account("457508000").valid must beTrue
    }
    "know if an account number is not valid" in {
      val parser = new NumberParser()
      Account("664371495").valid must beFalse
    }
  }

}
