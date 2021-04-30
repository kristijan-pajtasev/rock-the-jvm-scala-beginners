package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // EXPRESSION
  println(x)

  println(2 + 3 + 4)
  // + - * / & | << >> >>> (right shift with 0 extension)

  println(1 == x)
  // == != > < >= <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /=
  println(aVariable)

  // Instruction (DO) vs Expression (VALUE)

  // IF expression
  val aCondition = true
  var aConditionValue = if(aCondition) 5 else 3 // if is also an expression
  println(aCondition)
  println(if(aCondition) 5 else 3)

  var i = 0
  val aWhile = while(i < 10) {
    println(i)
    i += 1
  }

  // never write this again

  // everything in scala is an expression

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if(z > 2) "hello" else "goodbye"
  }

  println(aCodeBlock)

  // 1. diff between "hello world" and println("hello world")
  // string vs unit

  // 2. val of:
  val someValue = {
    2 < 3
  } // true

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  } //42
}
