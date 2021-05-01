package lectures.part2oop

object OOBasics extends App {
  val person = new Person("john", 26)
  println(person.x)
  person.greet("Daniel")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(imposter))
}

//constructor
class Person(name: String, val age: Int = 0)  {
  val x = 2

  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  def greet(): Unit = println(s"Hi, i am ${this.name}")

  def this(name: String) = this(name, 0)
}

//class params are not fields


// Novel and Writer class
// Writer: first name, surname, year
// method fullname

class Writer(firstName: String, surname: String, val year: Int) {
  def fullName: String = s"$firstName $surname"
}

// Novel: name, year of release, author
// - authorAge
// isWrittenBy(author)
// copy(new year of release) = new instance of Novel
class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}


// Counter class
// -receives int
// - method current count
// / method to increment/decrement => new Counter
// - overload inc/dec to receive an amount
class Counter(val count:Int) {
  def inc = new Counter(count + 1) // immutability
  def dec = new Counter(count - 1) // immutability

  def inc(n: Int): Counter = {
    if(n<=0) this
    else inc.inc(n-1) // first returns new counter, and has new inc called on it
  }

  def dec(n: Int): Counter = {
    if(n<=0) this
    else dec.dec(n-1)
  }
}