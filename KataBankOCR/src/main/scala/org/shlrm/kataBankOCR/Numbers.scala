package org.shlrm.kataBankOCR

object Numbers {

  val  zero =
    " _ \n" +
    "| |\n" +
    "|_|"
  val   one =
    "   \n" +
    "  |\n" +
    "  |"
  val   two =
    " _ \n" +
    " _|\n" +
    "|_ "
  val three =
    " _ \n" +
    " _|\n" +
    " _|"
  val  four =
    "   \n" +
    "|_|\n" +
    "  |"
  val  five =
    " _ \n" +
    "|_ \n" +
    " _|"
  val   six =
    " _ \n" +
    "|_ \n" +
    "|_|"
  val seven =
    " _ \n" +
    "  |\n" +
    "  |"
  val eight =
    " _ \n" +
    "|_|\n" +
    "|_|"
  val  nine =
    " _ \n" +
    "|_|\n" +
    " _|"

  val map =
  " # \n" +
  "###\n" +
  "###"

  def fromString(s: String): Char = s match {
    case `one`   => '1'
    case `two`   => '2'
    case `three` => '3'
    case `four`  => '4'
    case `five`  => '5'
    case `six`   => '6'
    case `seven` => '7'
    case `eight` => '8'
    case `nine`  => '9'
    case `zero`  => '0'
    case _       => '?'
  }

  val allNums = List(one,two,three,four,five,six,seven,eight,nine,zero)
}

class Number(original: String) {
  val parsedValue = Numbers.fromString(original)

  /**
   * Report the degree of difference between this number and a different one
   * Just returns the number of changes, either pipes or _s
   * @param other
   */
  def difference(other: String) = {
    val mine = original.toCharArray.toList
    val theirs = other.toCharArray.toList
    val map = Numbers.map.toCharArray.toList

    (0 to (Numbers.map.size-1)).foldLeft(0)((acc, idx) => {
      if (map(idx) == '#' && mine(idx) != theirs(idx)) {
        acc + 1
      } else {
        acc
      }
    })
  }

  lazy val otherPossibilities = {
    for(
      p <- Numbers.allNums
      if (difference(p) == 1)
    ) yield {
      new Number(p)
    }
  }

  override def toString = {
    parsedValue.toString
  }
}