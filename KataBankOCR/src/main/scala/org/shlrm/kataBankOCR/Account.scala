package org.shlrm.kataBankOCR

import org.shlrm.kataBankOCR.Numbers._

/**
 * Convenience object so that it's a bit easier to do the fun things that we want
 */
object Account{
  /**
   * this lets us do things like: Account("123456789")
   * @param number
   * @return
   */
  def apply(number:String):Account = {
    new Account(number)
  }

  /**
   * This lets me load in a parsed file, or any number of lines, and converts them
   * into a list of Account
   * @param lines
   * @return
   */
  def fromOCR(lines: List[List[String]]):List[Account] = {
    lines.map(unparsed => {
      //Collect a number out of the first 3 characters of all three lists
      val line1 = unparsed(0).grouped(3).toList
      val line2 = unparsed(1).grouped(3).toList
      val line3 = unparsed(2).grouped(3).toList

      //I know that there are 9 numbers in a line
      val accountNumber = (0 to 8).foldLeft("")((acc, index) => {
        acc + fromString(s"${line1(index)}\n${line2(index)}\n${line3(index)}")
      })
      Account(accountNumber)
    })
  }
}

/**
 * represents an account, hooray for encapsulation :D
 * @param accountNumber
 */
class Account(accountNumber: String) {

  lazy val valid: Boolean = {
    val ints = accountNumber.map(x => {
      x.asDigit
    }).toList

    def checksum(acc: Int, xs: List[Int]): Boolean = {
      if (xs.isEmpty)
        acc % 11 == 0
      else {
        checksum(acc + xs.head * xs.size, xs.tail)
      }
    }
    checksum(0, ints)
  }

  lazy val status: String = {
    ???
  }

  override def toString = {
    s"${accountNumber}"
  }

}
