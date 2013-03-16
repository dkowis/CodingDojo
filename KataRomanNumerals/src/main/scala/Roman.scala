object Roman {
  val ones = Vector("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")
  val tens = Vector("X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
  val hundreds = Vector("C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
  val thousands = Vector("M", "MM", "MMM")
  val toRoman = Vector(ones, tens, hundreds, thousands)

  def apply(number: Int): String = {
    assert(number <= 3000)
    assert(number > 0)

    def convert(acc: List[String], normal: List[Char]): List[String] = {
      if (normal.isEmpty) {
        acc
      } else {
        if (normal.head == '0') {
          convert("" :: acc, normal.tail)
        } else {
          val pos = normal.size - 1
          val index = augmentString(normal.head.toString).toInt - 1
          convert(toRoman(pos)(index) :: acc, normal.tail)
        }
      }
    }
    convert(List(), number.toString.toList).reverse mkString ""
  }
}
