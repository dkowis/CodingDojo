package org.shlrm.codingDojo.kataPotter


/**
 * This is because I'm lazy and don't want to type much
 */
object Book {
  val first = 1
  val second = 2
  val third = 3
  val fourth = 4
  val fifth = 5
}

case class Cart(books: Map[Int, Int]) {
  val single = 8

  val discounts: List[Double] = {
    /**
     * check to see if the map contains all of the keys specified in the list
     * @param map
     * @param want
     * @return
     */
    def hasUnique(map: Map[Int, Int], want: Int): Boolean = {
      map.keySet.size >= want
    }

    def discountsOfSize(acc: List[Double], myBooks: Map[Int, Int], size: Int): List[Double] = {
      if (myBooks.keySet.isEmpty || size == 0) {
        acc
      } else {
        if (hasUnique(myBooks, size)) {
          //All of the keys are in here, I can make a group of the requested size
          //TODO: need to only map however many are in the unique group size, not *all* the keys
          val toChange = myBooks.keySet.take(size)
          val next = myBooks.map(p => {
            //Filter the map, removing one from the count of each item in the wants
            if (toChange.contains(p._1)) {
              (p._1, p._2 - 1)
            } else {
              (p._1, p._2)
            }
          }).filterNot(p => p._2 == 0)
          //make a discount of size
          val discount = Discount(size);
          //again with the same size!
          discountsOfSize(discount :: acc, next, size)
        } else {
          //Not all the things are in here, need to recurse with a smaller size
          discountsOfSize(acc, myBooks, size - 1)
        }
      }
    }

    //Woot figured out how to do it with pattern matching! A WINNER IS ME
    discountsOfSize(List(), books, 5).grouped(2).toList.map(l => {
      l match {
        case List(Discount.three, Discount.five) => List(Discount.four, Discount.four)
        case _ => l
      }
    }).flatten
  }

  val cost: Double = {
    def discount(count: Int, discount: Double): Double = {
      count * single * (1 - discount)
    }

    if (books.isEmpty) {
      0
    } else {
      val leHax = discounts.foldLeft(0.0)((acc, v) => {
        acc + discount(Discount.count(v), v)
      })
      leHax
    }
  }

  def mappedString(map: Map[Int, Int]) = {
    //GO from the mapped values to a set of strings
    //OH GOD I"M DUMB -- Use the map, not the one from the class
    map.foldLeft(List[Int]())((acc: List[Int], p) => {
      (1 to p._2).foldLeft(List[Int]())((a: List[Int], i) => {
        val wat = p._1 match {
          case Book.first => 1
          case Book.second => 2
          case Book.third => 3
          case Book.fourth => 4
          case Book.fifth => 5
        }
        wat :: a
      }) ++ acc
    }) mkString ","
  }

  override def toString = {
    mappedString(books)
  }
}
