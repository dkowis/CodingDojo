package org.shlrm.codingDojo.kataPotter

case class Cart2(books: List[Int]) {

  val single = 8

  val cost: Double = {
    /**
     * Produce a something that contains as many groups of unique books as possible
     * Allows the specification of the size, to request a pair, or 3 or 4 or 5
     * Should return all those groups, and then the leftovers. Maybe a list of discounts
     * I can go from discount to book count as well.
     *
     * Return the number of groups that can be made from this, and the leftover items
     * @param books
     * @param size
     * @return
     */
    def produceGroups(books:List[Int], size: Int):(Int, List[Int]) = {
      val comparator = (1 to size).toList

      ???
    }

    if (books.isEmpty) {
      0.0
    } else {
      //TODO: find unique groups in the list of a specified size
      if (books.size == 1) {
        single
      } else {
        produceGroups(books, 5)
        ???

      }
    }
  }
}
