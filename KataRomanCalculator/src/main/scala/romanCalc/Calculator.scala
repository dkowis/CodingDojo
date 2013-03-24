package romanCalc

object Calculator {
  val operands = Set("+")

  def calc(input:String):String = {
    val numbers = input.replaceAll("\\+", "").split(" ").toList
    val total = numbers.foldLeft(0)( (acc, x) => {
      val numeric =  Roman.toNormal(x)
      acc + numeric
    })
    Roman(total)
  }
}
