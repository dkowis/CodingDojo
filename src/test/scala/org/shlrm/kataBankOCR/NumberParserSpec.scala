package org.shlrm.kataBankOCR

import org.specs2.mutable._

class NumberParserSpec extends Specification {
  "The file with 123456789" should {
    "parse to 123456789" in {
      //hand file path to something
      def parser = new NumberParser("scannedPaper.txt")
      parser.value must beEqualTo(123456789)
    }
  }
}
