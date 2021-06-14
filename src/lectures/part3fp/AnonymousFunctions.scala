package lectures.part3fp

object AnonymousFunctions extends App{

  // anonymous function (LAMBDA)
  val doubler: Int => Int = x => x * 2

  // multiple parameters
  val adder : (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  println(justDoSomething) // function
  println(justDoSomething()) // call

  // curly braces with lambda
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR syntatic sugar
  val niceIncrement: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a + b, needs function def

  /*
  1. MyList replace all functionX calls with lambdas
  2. rewrite the "special" adder as anonymous function
   */

  val superAdder = (x: Int) => (y: Int) => x + y
  println(superAdder(3)(4))

}
