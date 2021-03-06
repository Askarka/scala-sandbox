package tasks.classes

trait Animal2 {
  val name = "Horse"
  def greeting = s"Привет, я - $name"
}

trait FairyTaleAnimal {
  val name = "Unicorn"
}

abstract class Pegasus extends Animal2 with FairyTaleAnimal {
  override val name: String = "Pegasus"
  println(name)
  override def greeting = s"${super.greeting} and new one"
}


object Attempt extends App {
  val p = new Pegasus{}
  p.greeting
}
