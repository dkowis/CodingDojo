package argParser


class Args(text:String, args: List[Arg[Any]]) {
  /*
  Argument rules:
  arg first starts with a - then a character
  Potential for a value immediately, or they could be additional flags
  -lwat could be  -l -> wat
  or -l -w -a -t

  -s "some string with quotes" Quoted consumes everything in the quotes
  -w -1 This is -w -> -1 not  -w    -1
  -s a string  --  wouldn't work, it'd error
  
   */

  val argMap:Map[String,Arg[Any]] = {
    //Parse the arguments in to the arg flag, and the value
    ???
  }

  def value[A](value: String => A) = {
    value
  }
}