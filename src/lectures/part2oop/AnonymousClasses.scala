package lectures.part2oop

object AnonymousClasses extends App {
  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahaha")
  }

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can i help?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println("hello")
  }
  jim.sayHi

  /*
  1. generic trait MyPredicate[-T] with little method test(T) => Boolean
  2. Generic trait MyTransformer[-A,B]
    - map(transformer) => MyList
    - filter(predicate) => MyList
    - flatMap(transformer from A to MyList[B]) => MyList[B]

    class EvenPredicate extends MyPredicate[Int]
    class StringToIntTransformer extends MyMyTransformer[String, Int]


    [1,2,3].map(n * 2) = [2,4,6]
    [1,2,3].filter(n % 2) = [2]
    [1,2,3].flatMap(n, n+1) = [1,2,2,3,3,4]
   */
}
