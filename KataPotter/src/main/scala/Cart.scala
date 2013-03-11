
case class Cart(first: Int, second: Int, third: Int, fourth: Int, fifth: Int) {
  val single = 8

  def cost:Double = {
    if (first == 0 && second == 0 && third == 0 && fourth == 0 && fifth == 0) {
      0
    } else {
      ???
    }
  }

}
