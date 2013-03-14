package org.shlrm.codingDojo.kataPotter

/**
 * Just something to contain my discounts
 */
object Discount {

  /**
   * Convert from a book count to a discount amount
   * @param count
   * @return
   */
  def apply(count: Int): Double = {
    count match {
      case 1 => one
      case 2 => two
      case 3 => three
      case 4 => four
      case 5 => five
    }
  }

  /**
   * Given a discount amount, tell me how many books that applies to
   * @param discount
   * @return
   */
  def count(discount: Double): Int = {
    discount match {
      case `one` => 1
      case `two` => 2
      case `three` => 3
      case `four` => 4
      case `five` => 5
    }
  }

  val one = 0
  val two = 0.05
  val three = 0.10
  val four = 0.20
  val five = 0.25
}