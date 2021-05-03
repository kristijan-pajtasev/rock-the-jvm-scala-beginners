package lectures.part2oop

object CaseClasses extends App{
  /*
  equals, hashCOde, toString
   */

  case class Person(name: String, age: Int)

  val jim = new Person("Jim", 34)

  // 1 class params are fields
  println(jim.name)

  // 2. sensible toString
  // syntatic sugar print(jim) === print(jim.tostring)
  println(jim.toString)
  println(jim)

  // 3 euqals and hasCode implemented OOTB
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // CCs have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // have companion object
  val thePerson = Person
  val mary = Person("Mary", 23)
  println(mary)

  //6. CC are serializable
  // AKKA

  // 7 have extractor patters = CCs can be used in PATTERN MATCHING




  // objects can be alos
  case object UnitedKingdom {
    def name: String = "The UK"
  }

  /*
  expand MyList - use case classes and case objects
   */
}
