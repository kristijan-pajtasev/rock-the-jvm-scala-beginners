package exercises

abstract class MyList[+A] {
  /*
  head = first element of list
  tail = remainder of the list
  isEmpty = is this list empty
  add(int) = new List with this element added
  toString => a string representation of the list
   */
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  override def  toString: String = "[" + printElements + "]"

  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]

  def foreach(f: A => Unit) : Unit

  def sort(compare: (A, A) => Int) : MyList[A]

  def zipWith[B, C](list: MyList[B], zip: (A, B)=> C): MyList[C]

  def fold[B](start: B)(operator: (B, A) => B): B
}

case object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  def foreach(f: Nothing => Unit): Unit = ()

  def sort(compare: (Nothing, Nothing) => Int) = Empty

  def zipWith[B, C](list: MyList[B], zip: (Nothing, B)=> C): MyList[C] =
    if(!list.isEmpty) throw new RuntimeException("Lists do not have same length")
    else Empty

  def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements

  def filter(predicate: A => Boolean): MyList[A] = {
    if(predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }
  def map[B](transformer: A => B): MyList[B] =
    new Cons(transformer(h), t.map(transformer))

  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  // hofs
  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if(sortedList.isEmpty) new Cons(x, Empty)
      else if(compare(x, sortedList.head)<= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  def zipWith[B, C](list: MyList[B], zip: (A, B)=> C): MyList[C] =
    if(list.isEmpty) throw new RuntimeException("Lists do not have same length")
    else new Cons(zip(h, list.head), t.zipWith(list.tail, zip))

  /*
  [1,2,3].fold(0)(+) =
  [2,3].fold(1)(+) =
  [3].fold(3)(+) =
  [].fold(6)(+) =
  6
   */
  def fold[B](start: B)(operator: (B, A) => B): B = {
    t.fold(operator(start, h))(operator)
  }
}

object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val cloneListOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  print(listOfIntegers.toString)
  print(listOfStrings.toString)

  print(listOfIntegers.map(elem => elem * 2).toString)

  println(listOfIntegers ++ anotherListOfIntegers)
  println(listOfIntegers.flatMap(elem => new Cons(elem, new Cons(elem + 1, Empty))
  ).toString)

  println(listOfIntegers == cloneListOfIntegers)

  listOfIntegers.foreach(println)
  println(listOfIntegers.sort((x, y) => y - x))

  println(anotherListOfIntegers.zipWith[String, String](listOfStrings, _ + "-" + _))

  println(listOfIntegers.fold(0)(_ + _))

  // for comprehensions
  val combinations = for{
    n <- listOfIntegers
    string <- listOfStrings
  } yield n + "-" + string

  println(combinations)
}