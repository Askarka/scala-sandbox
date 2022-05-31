package interviewpreparation.implicits

import scala.language.implicitConversions

object ImplicitConversions {
  class A

  trait Togglable {
    def toggle(): Unit
  }

  implicit def toTogglable(a: A): Togglable = new A with Togglable {
    override def toggle(): Unit = println("Hello")
  }

  def main(array: Array[String]): Unit = {
    val a = new A
    a.toggle()
  }
}
