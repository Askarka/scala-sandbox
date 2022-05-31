package interviewpreparation.implicits

import interviewpreparation.implicits.ImplicitConversions.{A, Togglable}

import scala.language.implicitConversions

object implicitClasses {
  implicit class RichA1(a: A) extends Togglable {
    override def toggle(): Unit = println("Hello, implicit class")
  }

  // equals

  class RichA2(a: A) extends Togglable {
    override def toggle(): Unit = println("Hello, implicit class")
  }
  implicit final def RichA(a: A): RichA2 = new RichA2(a)
}
