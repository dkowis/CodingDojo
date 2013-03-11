import org.specs2.mutable._

class CartSpec extends Specification {

  "Discounts are computed correctly" >> {
    "for 0 books" in {
      val cart = new Cart(0,0,0,0,0)
      cart.cost === 0
    }
    "for 1 book" in {
      pending
    }
    "for 2 different books" in {
      pending
    }
    "for 2 identical books" in {
      pending
    }
    "for 3 different books" in {
      pending
    }
    "for 2 identical books and 1 other book" in {
      pending
    }
    "for 4 different books" in {
      pending
    }
    "for 5 different books" in {
      pending
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
      pending
    }
  }
}
