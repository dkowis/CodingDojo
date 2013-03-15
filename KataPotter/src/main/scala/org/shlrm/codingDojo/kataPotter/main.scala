package org.shlrm.codingDojo.kataPotter

import org.shlrm.codingDojo.kataPotter.Book._

object main {
  def main(args: Array[String]): Unit ={
    //val cart = new Cart(Map(first -> 2, second -> 1, third -> 2, fourth -> 1))
    //wants 3 discounts of 5 and 2 discounts of 4, rather than 4 discounts of 5 and one discount of 2
    val cart = new Cart(Map(first -> 5, second -> 5, third -> 4, fourth -> 5, fifth ->4)) //Should be 141.2
    println(s"Working: ${cart.toString}")
    cart.cost

    //val cart = new Cart(Map(first -> 1, second -> 2))
    //cart.cost
    //println(s"Cart cost should be 51.20 and is ${cart.cost}")
    //val cart = new Cart2(List(1,2))
    //cart.cost
  }
}
