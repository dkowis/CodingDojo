package org.shlrm.codingDojo.kataPotter

import org.specs2.mutable._

class WtfSpec extends Specification {
 "what the heck is going on" >> {
   "map.filter doesn't work???" in {
     val map = Map("key1" -> 1, "key2" -> 2, "key3" -> 3, "key4" -> 4)
     val thingsToKeep = List("key1", "key2")

     thingsToKeep.contains("key1") must beTrue

     val newMap = map.filter(p => {
       thingsToKeep.contains(p._1)
     })

     newMap must havePairs("key1" -> 1, "key2" -> 2)
   }
 }
}
