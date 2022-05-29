import scala.collection.mutable

class Animal
class Cat extends Animal
class BrownCat extends Cat

val mutableCats = mutable.ArrayBuffer[Cat]()
mutableCats.addOne(new Cat)

def greet[T <: Animal](animals: mutable.ArrayBuffer[T]): Unit =
  animals.foreach(println)
// bounded existential type:
def greet(animals: mutable.ArrayBuffer[_ <: Animal]): Unit =
  animals.foreach(println)
// this does not compile:
//def addCat[T <: Animal](animals: mutable.ArrayBuffer[T]) =
//  animals.addOne(new Cat)
// this does:
def addCat[T >: Animal](cats: mutable.ArrayBuffer[T]) =
  cats.addOne(new Cat)

