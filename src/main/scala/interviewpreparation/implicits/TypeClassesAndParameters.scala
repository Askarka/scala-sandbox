package interviewpreparation.implicits

import scala.runtime.Nothing$

object TypeClassesAndParameters {
  abstract class Semigroup[a] {
    def combine(x: a, y: a): a
  }

  abstract class Monoid[a] extends Semigroup[a] {
    def unit: a
  }

  implicit object stringMonoid extends Monoid[String] {
    def combine(x: String, y: String): String = x concat y

    def unit = ""
  }

  implicit object intMonoid extends Monoid[Int] {
    def combine(x: Int, y: Int): Int = x + y

    def unit = 0
  }

  def main(array: Array[String]): Unit = {

    def sumWithoutImplicit[a](xs: List[a])(m: Monoid[a]): a = {
      if (xs.isEmpty) m.unit
      else m.combine(xs.head, sumWithoutImplicit(xs.tail)(m))
    }

    println(sumWithoutImplicit(List("a", "b"))(stringMonoid))
    println(sumWithoutImplicit(List(1, 2))(intMonoid))

    def sumWithImplicit[a](xs: List[a])(implicit m: Monoid[a]): a = {
      if (xs.isEmpty) m.unit
      else m.combine(xs.head, sumWithImplicit(xs.tail)(m))
    }

    println(sumWithImplicit(List("a", "b")))
    println(sumWithImplicit(List(1, 2)))

    def afunk(a: => Nothing): Int = 45
    afunk(throw new Exception)



  }
}
