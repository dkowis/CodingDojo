package org.shlrm.kataBankOCR

import org.specs2.mutable.Specification
import io.Source

class UseCase4Spec extends Specification {
   "The file with the tests for usecase4" should {
     "produce a list of findings" in {
       val source = Source.fromURL(getClass.getResource("/usecase4.txt"))
       val parsed = FileParser.parse(source)
       Account.fromOCR(parsed).map(_.rectified) must beEqualTo(
         List(
         "711111111",
         "777777177",
         "200800000",
         "333393333",
         "888888888 AMB ['888886888', '888888880', '888888988']",
         "555555555 AMB ['555655555', '559555555']",
         "666666666 AMB ['666566666', '686666666']",
         "999999999 AMB ['899999999', '993999999', '999959999']",
         "490067715 AMB ['490067115', '490067719', '490867715']",
         "123456789",
         "000000051",
         "490867715"
         )
       )
     }
   }
 }
