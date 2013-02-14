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
    "|_|\n  |"
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
}
