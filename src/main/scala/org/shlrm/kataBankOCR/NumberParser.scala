package org.shlrm.kataBankOCR

import io.Source
import Numbers._

class NumberParser() {

  /**
   * Reads in a source, and returns a list of all the lines in it, grouped by the 4 lines per account
   * @return
   */
  def loadFile(source: Source): List[List[String]] = {
    val grouped = source.getLines().grouped(4)
    //TODO: could probably map, if I can map on an iterator...
    grouped.foldLeft(List[List[String]]())((coll, strings) => {
      strings.toList :: coll
    }).reverse
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

  def value: Int = {


    0
  }

}
