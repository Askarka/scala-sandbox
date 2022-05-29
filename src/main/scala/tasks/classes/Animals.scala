package tasks.classes

trait Animal {
  val sound: String
  def voice(): Unit = println("voice: " + sound)
}
class Cat extends Animal {
  val sound: String = "Meow!"
}
class Dog extends Animal {
  val sound: String = "Woof!"
}
class Fish extends Animal {
  override def voice(): Unit = println("Fishes are silent!")
  override val sound: String = ""
}

object Main extends App {
  val animals = Seq(new Cat, new Dog, new Fish)
  animals.foreach(_.voice())
}