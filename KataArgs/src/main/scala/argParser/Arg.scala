package argParser

/**
 * Case class to represent an argument. Might have to also specify the parsing algorithm
 * @param flag
 * @param convert
 * @tparam A
 */
case class Arg[A](flag: String, convert: String => A, consume: List[String] => String)

object Arg {
  def bool(flag: String) = new Arg(flag, x => augmentString(x).toBoolean, tokens => "") //Boolean flags don't take anything

  def int(flag: String) = new Arg(flag, x => augmentString(x).toInt, tokens => {
    ""
  })
}
