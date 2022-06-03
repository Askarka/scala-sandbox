package interviewpreparation.cats

import cats.data.{Validated, ValidatedNel}
import cats.implicits.catsSyntaxTuple3Semigroupal
//import cats.implicits.{catsSyntaxEitherId, catsSyntaxOptionId, catsSyntaxTuple3Semigroupal, catsSyntaxValidatedId, none}
import cats.syntax.either._
import cats.syntax.option._
import cats.syntax.validated._

object tips extends App {
  val a: Option[Int] = 1.some
  val b: Option[Nothing] = none
  val c: Either[Nothing, Int] = 2.asRight
  val c1: Either[String, Int] = 2.asRight[String]
  val d: Either[Int, Nothing] = 3.asLeft
  val d1: Either[Int, String] = 3.asLeft[String]
  val e: Validated[Nothing, Int] = 4.valid
  val f: Validated[Int, Nothing] = 5.invalid
  val h: ValidatedNel[Nothing, Int] = 6.validNel
  val g: ValidatedNel[Int, Nothing] = 7.invalidNel

  //В отличие от вариантов конструктора, возвращаемые типы этих методов сразу расширены до супертипа, т.е.:
  val a1: Some[String] = Some("a")
  val a2: Option[String] = "a".some
  println((List(1, 2), List(3, 4), List(0, 2)).mapN(_ * _ * _))

}
