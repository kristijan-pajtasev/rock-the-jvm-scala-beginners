package lectures.part2oop

object InheritanceAndTraits extends App{
  class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }
  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

//  class Dog extends Animal {
  class Dog(override val creatureType: String) extends Animal {
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
//    override val creatureType = "domestic"
  }

  val dog = new Dog("domestic")
  dog.eat
  println(dog.eat)

  //type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")

  // overRiding vs overLoad
  // one changes, other adds different type

  // super

  //preventing overrides - final
  // 1 final method
  // 2 final class
  // seal class - final outside but allows override in same file
}
