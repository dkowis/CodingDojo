package org.shlrm.kataBankOCR

import org.shlrm.kataBankOCR.Numbers._

/**
 * Convenience object so that it's a bit easier to do the fun things that we want
 */
object Account {
  /**
   * this lets us do things like: Account("123456789")
   * @param number
   * @return
   */
  def apply(number: String, ocrNumbers: List[Number]): Account = {
    new Account(number, ocrNumbers)
  }

  def apply(number: String): Account = {
    new Account(number)
  }

  /**
   * This lets me load in a parsed file, or any number of lines, and converts them
   * into a list of Account
   * @param lines
   * @return
   */
  def fromOCR(lines: List[List[String]]): List[Account] = {
    lines.map(unparsed => {
      //Collect a number out of the first 3 characters of all three lists
      val line1 = unparsed(0).grouped(3).toList
      val line2 = unparsed(1).grouped(3).toList
      val line3 = unparsed(2).grouped(3).toList

      //I know that there are 9 numbers in a line
      val ocrNumbers = (0 to 8).foldLeft(List[Number]())((acc, index) => {
        val num = new Number(s"${line1(index)}\n${line2(index)}\n${line3(index)}")
        num :: acc
      }).reverse

      val accountNumber = ocrNumbers.foldLeft("")((acc, i) => {
        acc + i.parsedValue
      })
      Account(accountNumber, ocrNumbers)
    })
  }

  def fromNumbers(numbers: List[Number]): Account = {
    Account(numbers.foldLeft("")((acc, n) => {
      acc + n.parsedValue
    }))
  }
}

/**
 * represents an account, hooray for encapsulation :D
 * @param accountNumber
 */
class Account(accountNumber: String, ocrNumbers: List[Number] = List()) {

  lazy val valid: Boolean = {
    if (accountNumber.contains('?'))
      false
    else {
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
  }

  lazy val status: String = {
    if (accountNumber.contains("?"))
      "ILL"
    else if (!valid)
      "ERR"
    else
      ""
  }

  /**
   * Do all the things that are required in Use Case 4!
   * Think about recursion!
   * Should be alist of all other possible Accounts that could come from this garbage one
   */
  lazy val rectified = {
    //Build a list of all possible account numbers that could exist from this one where only one bar/line is missing
    def tryAccounts(acc: List[Account], done: List[Number], rem: List[Number]): List[Account] = {
      if (rem.isEmpty) {
        acc
      } else {
        val altAccts = rem.head.otherPossibilities.map(x => {
          val acct = Account.fromNumbers(done ::: List(x) ::: rem.tail)
          if (acct.valid)
            acct
          else
            null
        }).filterNot(_ == null)
        acc ::: altAccts ::: tryAccounts(acc, done ::: List(rem.head), rem.tail)
      }
    }

    val fixed = tryAccounts(List(), List(), ocrNumbers).sortBy( x => x.toString)

    //Format the output for the report
    if (fixed.size == 1) {
      //Single possible account
      fixed.head.toString
    } else if (fixed.size > 1) {
      //Multiple possible accounts, need to build a pretty string of mine, and other accounts
      val joined = fixed.map(x => s"'${x.toString}'").mkString(", ")
      s"${toString} AMB [${joined}]"
    } else {
      //No possible accounts!(Not covered in the test cases)
      "UNDEFINED"
    }
  }

  val report = {
    s"${accountNumber} ${status}".trim
  }

  override def toString = {
    s"${accountNumber}"
  }

}
