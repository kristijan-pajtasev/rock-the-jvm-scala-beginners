package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def hangoutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(person: String): Person = new Person(s"$name ($person)", favoriteMovie, age)

    def unary_! : String = s"$name, what the heck!"

    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def isAlive: Boolean = true

    def learns(thing: String) = s"$name is learning $thing"

    def learnsScala = learns("Scala")

    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"

    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception")
  // infix notation = operator notation - syntactic sugar

  val tom = new Person("Tom", "Fight Club")
  println(mary hangoutWith tom)
  println(mary + tom)

  // ALL OPERATOR ARE METHODS
  println(1.+(2))

  // prefix notation
  val x = -1
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary())

  // 1 overload + operator
  // mary + "the rockstar" => new Person("Mary (the rockstar)"
  println((mary + "the Rockstar").apply())

  // 2 add an age to person
  // add a unary + operator => new person with age + 1
  println((+mary).age)

  // 3. add learns method
  // => "Mary learns Scala"
  // add learnsScala method that calls learns with scala
  // use it in postfix
  println(mary learns "scala" )
  println(mary learnsScala)

  // 4. overload the apply method
  // mary.apply(2) => mary watched inception 2 times
  println(mary(2))

}
