package lectures.part2oop

object Exceptions extends App {
  val x: String = null

//  println(x.length)
  // this will crash with null pointer
  // throwing and catching exceptions

  // 1 throwing exceptions
//  val aWeirdValue: String = throw new NullPointerException // return Nothing

  // throwable classes extend Throwable class
  // Exceptions and Error are major Throwable subtypes


  // 2 catching exceptions
  def getInt(withExceptions: Boolean): Int =
    if(withExceptions) throw new RuntimeException("No int for you")
    else 42

  val potentialFail = try {
    getInt(true)
  } catch {
    case e: RuntimeException => println("caught a runtime exceptiom")
  } finally {
    // code that will get executed no matter what
    // optional
    // does not affect return type
    println("finally")
  }

  println(potentialFail)

  // 3 define own exception
  class MyException extends Exception
  val exceptions = new MyException
//  throw exceptions

  /*
  1. Crash your program with OutOfMemeoryError
  2. Crash your program with SOError
  3. pocket calculator
   - add
   - subtract
   - multiply
   - divide

   Throw
    - overflow exception if add(x,y) > Int.max_value
    - underflow exception if subtract < int.min_value
    - mathcalculationexception for division by 0
   */

  // 1
//  val array = Array.ofDim(Int.MaxValue)

  // 2.
//  def infitnite: Int = 1 + infitnite
//  val noLimit = infitnite


  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y
      if(x > 0 && y > 0 && result < 0) throw new OverflowException
      else if(x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int) = {
      val result = x - y
      if(x > 0 && y < 0 && result < 0) throw new OverflowException
      if(x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def mutliply(x: Int, y: Int) = {
      val result = x * y
      if(x > 0 && y > 0 && result < 0) throw new OverflowException
      else if(x < 0 && y < 0 && result < 0) throw new OverflowException
      else if(x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if(x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if(y == 0) throw new MathCalculationException
      else x / y
    }
  }


  println(PocketCalculator.divide(1, 0))
}

