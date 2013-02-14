package org.shlrm.kataBankOCR

import io.Source
import Numbers._
import collection.immutable.Range

class NumberParser() {

  /**
   * Reads in a source, and returns a list of all the lines in it, grouped by the 4 lines per account
   * @return
   */
  def loadFile(source: Source): List[List[String]] = {
    val grouped = source.getLines().grouped(4)
    grouped.map(group => group.toList).toList
  }

  /**
   * Convert the lines into a list of account numbers as text instead!
   * @param lines
   */
  def toNumber(lines: List[List[String]]) = {
    lines.map(unparsed => {
      //Collect a number out of the first 3 characters of all three lists
      val line1 = unparsed(0).grouped(3).toList
      val line2 = unparsed(1).grouped(3).toList
      val line3 = unparsed(2).grouped(3).toList

      //I know that there are 9 numbers in a line
      val accountNumber = (0 to 8).foldLeft("")((acc, index) => {
        acc + fromString(s"${line1(index)}\n${line2(index)}\n${line3(index)}")
      })
      accountNumber
    })
  }

  def validAccount(acct: String): Boolean = {
    val ints = acct.map(x => {
      x.asDigit
    }).toList

    def checksum(acc:Int, xs:List[Int]):Boolean = {
      if (xs.isEmpty)
        acc % 11 == 0
      else {
        checksum(acc + xs.head * xs.size, xs.tail)
      }
    }
    checksum(0, ints)
  }
}
