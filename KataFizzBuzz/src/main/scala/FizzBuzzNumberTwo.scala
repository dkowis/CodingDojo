object FizzBuzzTwo {
  def apply(value: Int) = {
    lazy val fizzBuzzStream: Stream[FizzBuzzNumberTwo] = new FizzBuzzNumberTwo(value) #:: fizzBuzzStream.map {
      n =>
        new FizzBuzzNumberTwo(n.v + 1)
    }
    fizzBuzzStream
  }
}

case class FizzBuzzNumberTwo(v: Int) {
  val value = {
    val string = v.toString()
    if ((v % 3 == 0 && v % 5 == 0) ||
      (string.contains("3") && string.contains("5"))) {
      "FizzBuzz"
    } else if (v % 3 == 0 || string.contains("3")) {
      "Fizz"
    } else if (v % 5 == 0 || string.contains("5")) {
      "Buzz"
    } else {
      v.toString
    }
  }

}
