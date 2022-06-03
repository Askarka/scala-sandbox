package experiments.linearization

// Scala program for trait linearization
// defining classes and traits
class flavour {
  def make(flavour: String): Unit = {
    println(flavour)
  }
}

// defining texture trait
trait texture extends flavour {
  abstract override def make(flavour: String) {
    super.make(flavour + "texture ")
  }
}

// defining cream trait
trait cream extends texture {
  abstract override def make(flavour: String) {
    super.make(flavour + "with cream ")
  }
}

// defining jelly trait
trait jelly extends texture {
  abstract override def make(flavour: String) {
    super.make(flavour + "with jelly ")
  }
}

// defining cone trait
trait cone extends flavour {
  abstract override def make(flavour: String) {
    super.make(flavour + "in cone ")
  }
}

// creating new ice-cream flovours
// with above traits and classes
// inheriting different traits and classes
class Myflavour extends flavour with jelly {
  override def make(flavour: String) {
    super.make(flavour)
  }
}

class Myflavour2 extends flavour with cream with cone {
  override def make(flavour: String) {
    super.make(flavour)
  }
}

// Creating object
object GFG1 {
  // Main method
  def main(args: Array[String]) {
    // creating new objects
    var icecream1 = new Myflavour
    var icecream2 = new Myflavour2 with jelly
    println(icecream1.make("chocolate "))
    println(icecream2.make("vanilla "))
  }
}
