package tasks.classes

class Waiter(name: String, order: List[String], newOne: Boolean = true) {
  def greet(): Unit = println(s"My name $name")
  if (newOne) greet()
  def giveMe(foodName: String) = new Waiter(name, order :+ foodName, false)

  def complete(): List[String] = order
}
