package org.shlrm.kataBankOCR

import io.Source

class NumberParser() {

  /**
   * Lets read in the entire file, and get a List of List of strings, 3 lines for each entry
   * @return
   */
  def loadFile(source: Source): List[List[String]] = {
    val grouped = source.getLines().grouped(4)
    grouped.foldLeft(List[List[String]]())((coll, strings) => {
      strings.toList :: coll
    }).reverse
  }

  /**
   * Take an account number and return the nine digits that are it
   * Get a list of list of strings, then we can go through each one and determine if it properly matches things
   * @param lines
   */
  def toNumber(lines:List[List[String]]) = {
    /*
    Convert the list of strings to a matrix of things that look like LED numbers
    Specifically a list of two dimensional arrays (or whatever the non mutable thing is for that)
    x_x 010
    |_| 111
    |_| 111
     */


  }

  def value: Int = {


    0
  }

}
