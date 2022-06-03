package experiments.linearization

// Scala program defining trait A
trait A {
  def name: String
}

// defining trait B inheriting A
trait B extends A {
  override def name: String = "class b"
}

// defining trait C inheriting A
trait C extends A {
  override def name: String = "class c"
}

// defining class D inheriting B and C both
class D extends B with C {
  override def name: String = super.name
}

// Creating object
object GFG {
  // Main method
  def main(args: Array[String]): Unit = {
    var class_d = new D

    // whose property will be inherited
    println(class_d.name)
  }
}

