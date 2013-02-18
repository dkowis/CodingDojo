object FizzBuzz {
  def apply(value: Int): Stream[FizzBuzzNumber] = {
    lazy val fizzBuzzStream: Stream[FizzBuzzNumber] = new FizzBuzzNumber(value) #:: fizzBuzzStream.map {
      n =>
        new FizzBuzzNumber(n.v + 1)
    }
    fizzBuzzStream
  }
}


case class FizzBuzzNumber(v: Int) {
  val value = {
    if (v % 3 == 0 && v % 5 == 0) {
      "FizzBuzzNumber"
    } else if (v % 3 == 0) {
      "Fizz"
    } else if (v % 5 == 0) {
      "Buzz"
    } else {
      v.toString
    }
  }
}