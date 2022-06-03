package experiments.linearization

// Scala program for linearization
// defining old_car class
class old_Car {
  def method: String = "old car "
}

// defining new_Car_Designs trait
trait new_Car_Designs extends old_Car {
  override def method: String = "Designing-> " + super.method
}

// defining new_Car_Part trait
trait new_Car_Part extends old_Car {
  override def method: String = "Add new part-> " + super.method
}

// defining new_Car_Paint trait
trait new_Car_Paint extends old_Car {
  override def method: String = "Repainting-> " + super.method
}

// defining new_Car class
class new_Car extends new_Car_Paint with
  new_Car_Part with new_Car_Designs {
  override def method: String = "new car-> " + super.method
}

// Creating object
object geekforgeeks {
  // Main method
  def main(args: Array[String]) {
    // new_Car object
    var car1 = new new_Car
    println(car1.method)
  }
}
