class Person(val name: String)

class Student(name: String, val course: Int) extends Person(name)

class Pair[+T](val first: T, val second: T) {
  def replaceFirst[K >: T](newValue: K): Pair[K] = {
    new Pair(newValue, second)
  }
}

def printNames(pair: Pair[Person]): Unit = {
  println("1: " + pair.first.name + "  2: " + pair.second.name)
}

val pair = new Pair(new Student("Pavel", 1), new Student("Oleg", 5))
printNames(pair.replaceFirst(new Person("Oliver")))
