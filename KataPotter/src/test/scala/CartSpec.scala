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

  "Discounts are applied correctly for provided test cases" >> {
    "1,1,1" in {
      new Cart(Map(first -> 3)).cost === 8 * 3
    }

    "1,1,2" in {
      new Cart(Map(first -> 2, second -> 1)).cost === 8 + (8 * 2 * 0.95)
    }

    "1,1,2,2" in {
      new Cart(Map(first -> 2, second -> 2)).cost === 2 * (8 * 2 * 0.95)
    }
  }

  "Discounts are applied correctly for several discounts" >> {
    "1,1,2,3,3,4" in {
      new Cart(Map(first -> 2, second -> 2, third -> 2, fourth -> 1)).cost === (8 * 4 * 0.8) + (8 * 2 * 0.95)
    }

    "1,2,2,3,4,5" in {
      new Cart(Map(first -> 1, second -> 2, third -> 1, fourth -> 1, fifth -> 1)).cost === 8 + (8 * 5 * 0.75)
    }
  }

  "Discounts are applied correctly in edge cases" >> {
    "1,1,2,2,3,3,4,5" in {
      new Cart(Map(first -> 2, second -> 2, third -> 3, fourth -> 1, fifth -> 1)).cost === 2 * (8 * 4 * 0.8)
    }

    "1,1,1,1,1, 2,2,2,2,2, 3,3,3,3, 4,4,4,4,4, 5,5,5,5" in {
      new Cart(Map(first -> 5, second -> 5, third -> 4, fourth -> 5, fifth ->4)).cost === 3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8)
    }
  }
}
