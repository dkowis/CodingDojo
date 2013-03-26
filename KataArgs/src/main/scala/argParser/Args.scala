package argParser


case class Args(args: List[Arg]) {

}

object Args {
  def apply(args: List[Arg]) = new Args(args)
}
