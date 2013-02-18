object FizzBuzzOne {
  def apply(value: Int): Stream[FizzBuzzNumberOne] = {
    lazy val fizzBuzzStream: Stream[FizzBuzzNumberOne] = new FizzBuzzNumberOne(value) #:: fizzBuzzStream.map {
      n =>
        new FizzBuzzNumberOne(n.v + 1)
    }
    fizzBuzzStream
  }
}

case class FizzBuzzNumberOne(v: Int) {
  val value = {
    if (v % 3 == 0 && v % 5 == 0) {
      "FizzBuzzNumberOne"
    } else if (v % 3 == 0) {
      "Fizz"
    } else if (v % 5 == 0) {
      "Buzz"
    } else {
      v.toString
    }
  }
}