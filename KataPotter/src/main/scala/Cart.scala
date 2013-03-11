
case class Cart(books: Map[String, Int]) {
  val single = 8

  /**
   * Just something to contain my discounts
   */
  object Discount {
    val one = 0
    val two = 0.05
    val three = 0.10
    val four = 0.20
    val five = 0.25
  }

  def cost:Double = {

    def discount(count: Int, discount:Double):Double = {
      println(s"doing discount for ${count} items with a discount of ${discount}")
      count * single * (1 - discount)
    }

    if (books.isEmpty) {
      0
    } else {
      if (books.keySet.size == 1){
        println("doing something with things in here")
        discount(books.get(books.keySet.head).get,Discount.one)
      } else {
        ???
      }
    }
  }

}
