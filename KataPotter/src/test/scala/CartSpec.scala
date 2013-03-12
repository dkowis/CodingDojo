import org.specs2.mutable._
import Book._

class CartSpec extends Specification {

  "Discounts are computed correctly" >> {
    "for 0 books" in {
      val cart = new Cart(Map())
      cart.cost === 0
    }
    "for 1 book" in {
      val cart = new Cart(Map(first -> 1))
      cart.cost === 8
    }
    "for 2 different books" in {
      val cart = new Cart(Map(first -> 1, second -> 1))
      cart.cost === 15.2
    }
    "for 2 identical books" in {
      val cart = new Cart(Map(first -> 2))
      cart.cost === 16
    }
    "for 3 different books" in {
      val cart = new Cart(Map(first -> 1, second -> 1, third -> 1))
      cart.cost === 21.6
    }
    "for 2 identical books and 1 other book" in {
      val cart = new Cart(Map(first -> 2, second -> 1))
      cart.cost === 23.2
    }
    "for 4 different books" in {
      val cart = new Cart(Map(first -> 1, second -> 1, third -> 1, fourth -> 1))
      cart.cost === 25.6
    }
    "for 5 different books" in {
      val cart = new Cart(Map(first -> 1, second -> 1, third -> 1, fourth -> 1, fifth -> 1))
      cart.cost === 30
    }

    "for the example provided" in {
      /*
        2 copies of the first book
        2 copies of the second book
        2 copies of the third book
        1 copy of the fourth book
        1 copy of the fifth book
        answer: 51.20
      */
      val cart = new Cart(Map(first -> 2, second -> 2, third -> 2, fourth -> 1, fifth -> 1))
      cart.cost === 51.20
    }
  }
}
