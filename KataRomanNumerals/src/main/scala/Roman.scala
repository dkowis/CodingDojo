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

  def toNormal(roman:String):Int = {
    val uber = toRoman.reverse.map(iv => iv.reverse).flatten
    def convert(acc: List[Int], romans:String): List[Int] = {
      if (romans.isEmpty){
        acc
      } else {
        val found = uber.filter(numeral => romans.startsWith(numeral)).head
        val int = if (thousands.contains(found)) {
          1000 * (thousands.indexOf(found) +1)
        } else if (hundreds.contains(found)) {
          100 * (hundreds.indexOf(found) +1)
        } else if (tens.contains(found)) {
          10 * (tens.indexOf(found) +1)
        } else {
          ones.indexOf(found) + 1
        }
        convert(int :: acc, romans.replaceFirst(found, ""))
      }
    }
    convert(List(), roman).sum
  }
}
