package romanCalc

/**
 * Blatantly stolen from my other coding dojo
 */
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
    val allRomans = toRoman.reverse.map(iv => iv.reverse).flatten
    def convert(acc: List[Int], romans:String): List[Int] = {
      if (romans.isEmpty){
        acc
      } else {
        val found = allRomans.filter(numeral => romans.startsWith(numeral)).head
        //Fold up the maths for converting scales
        val int = toRoman.foldLeft(0)((acc, col) => {
          if (col.contains(found)){
            acc + math.pow(10, toRoman.indexOf(col)).toInt * (col.indexOf(found) + 1)
          } else {
            acc
          }
        })
        convert(int :: acc, romans.replaceFirst(found, ""))
      }
    }
    convert(List(), roman).sum
  }
}
