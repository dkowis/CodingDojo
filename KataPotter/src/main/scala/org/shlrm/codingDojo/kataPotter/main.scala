package org.shlrm.codingDojo.kataPotter

import org.shlrm.codingDojo.kataPotter.Book._

object main {
  def main(args: Array[String]): Unit ={
    val cart = new Cart(Map(first -> 2, second -> 2, third -> 2, fourth -> 1, fifth -> 1))
    cart.cost

    //val cart = new Cart(Map(first -> 1, second -> 2))
    //cart.cost
    //println(s"Cart cost should be 51.20 and is ${cart.cost}")
    //val cart = new Cart2(List(1,2))
    //cart.cost
  }
}
