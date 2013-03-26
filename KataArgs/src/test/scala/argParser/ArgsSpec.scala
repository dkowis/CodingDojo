package argParser

import org.specs2.mutable._

class ArgsSpec extends Specification {
  "Argument parser can parse arguments according to our spec" >> {
    "-l" in {
      Args(List(Arg.bool("l")))
    }
    "-avz" in {
      pending
    }
    "-c 10" in {
      pending
    }
    "-c10" in {
      pending
    }
    "-n \"woot os\"" in {
      pending
    }
    "--thingy-of-bigness" in {
      pending
    }
    "-m -1" in  {
      pending
    }
    "-avz" in {
      pending
    }
  }
}
