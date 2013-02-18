import org.specs2.mutable.Specification

class FizzBuzzTwoSpec extends Specification {
  "n % 3 or contains 3 == Fizz and n % 5, contains 5 == Buzz, both == FizzBuzz" should {
    "for 1" in {
      FizzBuzzTwo(1).take(1).toList.map(_.value) must beEqualTo(
        List("1")
      )
    }

    "for 1..10" in {
      FizzBuzzTwo(1).take(10).toList.map {
        _.value
      } must beEqualTo(
        List(
          "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz"
        )
      )
    }

    "for 10..20" in {
      FizzBuzzTwo(10).take(10).toList.map {
        _.value
      } must beEqualTo(
        List(
          "Buzz", "11", "Fizz", "Fizz", "14", "FizzBuzz", "16", "17", "Fizz", "19"
        )
      )
    }

    "for 50..60" in {
      FizzBuzzTwo(50).take(10).toList.map {
        _.value
      } must beEqualTo(
        List("Buzz", "Fizz", "Buzz", "FizzBuzz", "Fizz", "Buzz", "Buzz", "Fizz", "Buzz", "Buzz")
      )
    }

  }
}
