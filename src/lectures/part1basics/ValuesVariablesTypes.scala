package lectures.part1basics

object ValuesVariablesTypes extends App {
  //  vals are immutable
  val x: Int = 42;
  //  val x = 42; also good types are optional, compiler infers type
  println(x);

  val aString: String = "Hello"
  val anotherString = "goodbye"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt:Int = x
  val aShort: Short = 12342
  val aLong: Long = 21323322112321213L
  val aFloat: Float = 2.0f // needs f otherwise it is double
  val aDouble: Double = 3.14


  // variables
  var aVariable: Int = 4
  aVariable = 5 // side effect

}
