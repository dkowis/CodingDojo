package org.shlrm.codingDojo.kataPotter


/**
 * This is because I'm lazy and don't want to type much
 */
object Book {
  val first = "one"
  val second = "two"
  val third = "three"
  val fourth = "four"
  val fifth = "five"
}

case class Cart(books: Map[String, Int]) {
  val single = 8

  val discounts: List[List[Double]] = {
    def availableDiscounts(acc: List[Double], map: Map[String, Int], discountSize: Int): List[Double] = {
      if (map.isEmpty || discountSize <= 1) {
        acc
      } else {
        val discount = Discount(map.keySet.size)
        val newMap = map.mapValues(x => x - 1).filterNot(p => p._2 == 0)
        availableDiscounts(discount :: acc, newMap, discountSize)
      }
    }

    def allAvailableDiscounts(acc: List[List[Double]], map: Map[String, Int], maxDiscount: Int): List[List[Double]] = {
      //println(s"discounts for ${mappedString(map)}: ${acc mkString ","} max: ${maxDiscount}")
      if (map.isEmpty) {
        acc
      } else {
        if (maxDiscount == 1) {
          acc
        } else {
          val discountSize = if (map.keySet.size > maxDiscount) maxDiscount else map.keySet.size
          println ("")
          println(s"original map: ${mappedString(map)}")

          println(s"Discount size is ${discountSize}")
          val toRemoveKeys = map.keySet.take(discountSize)
          println(s"removing keys: ${toRemoveKeys mkString ","}")

          val first = map.filter(p => {
            def value = !toRemoveKeys.contains(p._1.toString)
            println(s"I don't even know how this is possible: ${value}")
            value
          })
          //I Don't understand how this can possibly be happening
          //THe output to the screen is different than the actual map itself, that's unpossible.
          println(s"first: ${mappedString(first)}")

          val second = first.mapValues(v => v -1)
          println(s"second: ${mappedString(second)}")

          val newMap = (map.filterKeys(k => toRemoveKeys.contains(k)).mapValues(v => v - 1) ++ map.filterKeys(k => !toRemoveKeys.contains(k))).filterNot(p => p._2 == 0)
          println(s"new map is: ${mappedString(newMap)}")
          allAvailableDiscounts(availableDiscounts(List(), newMap, maxDiscount) :: acc, newMap, maxDiscount) ++
            allAvailableDiscounts(availableDiscounts(List(), map, maxDiscount - 1) :: acc, map, maxDiscount - 1)
        }
      }
    }

    allAvailableDiscounts(List(), books, 5)
  }

  def cost: Double = {

    def discount(count: Int, discount: Double): Double = {
      count * single * (1 - discount)
    }

    if (books.isEmpty) {
      0
    } else {
      val leHax = discounts.foldLeft(0.0)((acc, v) => {
        val one = v.foldLeft(-1.0)((a, v1) => {
          a + discount(Discount.count(v1), v1)
        })
        //println(s"Comparing ${acc} with ${one} -- Discounts: ${v mkString ","}")
        if (acc == -1.0) {
          one
        } else {
          if (acc < one || one == 0) {
            acc
          } else {
            one
          }
        }
      })
      println(s"final cost is: ${leHax}")
      leHax
    }
  }

  def mappedString(map: Map[String, Int]) = {
    //GO from the mapped values to a set of strings
    books.foldLeft(List[Int]())((acc:List[Int], p) => {
      (1 to p._2).foldLeft(List[Int]())( (a:List[Int],i) => {
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