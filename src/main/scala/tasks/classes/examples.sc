trait Animal{
  val name = "Horse"
  def greeting = s"Привет, я - $name"
}
trait FairyTaleAnimal {
  val name = "Unicorn"
}
//object Pegasus extends Animal with FairyTaleAnimal{
//  println(name)
//  override def greeting = s"${super.greeting} and new one"
//}
//Pegasus.greeting
import tasks.classes.Waiter

class Dog(name: String){
  def woof(): Unit = println(s"$name")
}

val dog = new Dog("Gray")
dog.woof()
class Cat(val name: String) {
  def miay(): Unit = println(s"$name")
}
val cat = new Cat("White")
cat.name
cat.miay()


val waiter = new Waiter("Scot", Nil)
val positions = waiter.giveMe("hleb").giveMe("pasta").complete()

case class Cat2(name: String, age: Int)
val cat = Cat2("Pesy", 3)
println(cat)
cat.copy("Mercy")
