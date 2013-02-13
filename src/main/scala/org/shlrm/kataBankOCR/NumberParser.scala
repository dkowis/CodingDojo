package org.shlrm.kataBankOCR

class NumberParser(fileName: String) {

  def loadFile = {
    val source = scala.io.Source.fromFile(fileName)
    val lines = source.getLines()
    source.close()
  }

  def value:Int = ???

}
