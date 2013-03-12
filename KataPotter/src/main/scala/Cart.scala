
/**
 * This is because I'm lazy and don't want to type much
 */
object Book {
  val first = "one"
  val second = "two"
  val third = "three"
  val fourth = "four"
  val fifth = "five"
}

case class Cart(books: Map[String, Int]) {
  val single = 8

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

  val discounts = {
    def availableDiscounts(acc: List[Double], map: Map[String, Int]): List[Double] = {
      //Find all available discounts, including permutations (two sets of four)
      if (map.isEmpty) {
        acc
      } else {
        val discount = Discount(map.keySet.size)
        val newMap = map.mapValues(x => x - 1).filterNot(p => p._2 == 0)
        availableDiscounts(discount :: acc, newMap)
      }
    }

    availableDiscounts(List(), books)
  }

  def cost: Double = {

    def discount(count: Int, discount: Double): Double = {
      println(s"doing discount for ${count} items with a discount of ${discount}")
      count * single * (1 - discount)
    }

    if (books.isEmpty) {
      0
    } else {
      println(s"Discounts are: ${discounts mkString "," }")
      val leHax = discounts.foldLeft(0.0)((acc, v) => {
        acc + discount(Discount.count(v), v)
      })
      println(s"So cost is: ${leHax}")
      leHax
    }
  }

}
