import org.specs2.mutable.Specification

class FizzBuzzOneSpec extends Specification {
  "if a number is divisible by three you get Fizz and five you get Buzz both you get FizzBuzz" should {
    "for 1" in {
      FizzBuzzOne(1).take(1).toList.map {
        _.value
      } must beEqualTo(
        List("1")
      )
    }
    "for 1..2" in {
      FizzBuzzOne(1).take(2).toList.map {
        _.value
      } must beEqualTo(
        List("1", "2")
      )
    }
    "for 1..10" in {
      FizzBuzzOne(1).take(10).toList.map {
        _.value
      } must beEqualTo(
        List(
          "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz"
        )
      )
    }

    "for 10..20" in {
      FizzBuzzOne(10).take(10).toList.map {
        _.value
      } must beEqualTo(
        List(
          "Buzz", "11", "Fizz", "13", "14", "FizzBuzz", "16", "17", "Fizz", "19"
        )
      )
    }

    "for 50..60" in {
      FizzBuzzOne(50).take(10).toList.map {
        _.value
      } must beEqualTo(
        List("Buzz", "Fizz", "52", "53", "Fizz", "Buzz", "56", "Fizz", "58", "59")
      )
    }
  }
}
