package org.shlrm.kataBankOCR

import io.Source
import Numbers._
import collection.immutable.Range

object FileParser {
  /**
   * Reads in a source, and returns a list of all the lines in it, grouped by the 4 lines per account
   * @return
   */
  def parse(source: Source): List[List[String]] = {
    val grouped = source.getLines().grouped(4)
    grouped.map(group => group.toList).toList
  }
}
