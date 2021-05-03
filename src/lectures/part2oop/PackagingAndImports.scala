package lectures.part2oop

import playground.{Cinderella, PrinceCharming}
//import playground.{Cinderella => Princess}
//import playground._

object PackagingAndImports extends App{
  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  // import the package
  val princess = new Cinderella

  val princess2 = new playground.Cinderella

  //packages in hierarchy
  // matching folder structure

  //package object
  sayHello

  val prince = new PrinceCharming

  // default imports
  // java.lang
  // scala
  // scala.Predef
}
