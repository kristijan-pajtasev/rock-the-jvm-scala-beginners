package lectures.part1basics

object Recursion extends App {
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computing factorial of " + n)
      result
    }
  }

  println(factorial(10))

  // more optimised, tail recursion
  def anotherFactorial(n: Int): Int = {
    def factorialHelper(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator)
    }

    factorialHelper(n, 1)
  }

  println("new with acc: " + anotherFactorial(10))

  // 1. concatenate a string n times
  def concatenateTailRec(aString: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else concatenateTailRec(aString, n - 1, aString + accumulator)
  }

  print(concatenateTailRec("hello", 3, ""))


  // 2. is prime func
  def isPrime(n: Int): Boolean = {
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeTailRec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  // 3. fibb
  def fibonacci(n: Int): Int = {
    def fibbTailRec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i > n) last
      else fibbTailRec(i + 1, last + nextToLast, last)
    }

    if(n <= 2) 1
    else fibbTailRec(2, 1, 1)
  }

  println(fibonacci(8))

}
