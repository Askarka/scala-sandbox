package experiments

object DivideAndFlattenExampleObject extends App {

  import scala.annotation.tailrec

  def divide(p: (Int, Int))(q: (Int, Int)): Either[String, (Int, Int)] = {
    def incorrectFractionCheck(xy: (Int, Int)): Either[String, (Int, Int)] = if (math.abs(xy._1) < math.abs(xy._2))
      Right(xy) else Left("invalid input")

    def notSecondZeroValueCheck(xy: (Int, Int)): Either[String, (Int, Int)] = if (xy._2 != 0) {
      Right(xy)
    } else Left("Zero divisor")

    val c = notSecondZeroValueCheck(p)
    val d = notSecondZeroValueCheck(q)
    val e = notSecondZeroValueCheck((q._2, q._1))
    if (c.isLeft || d.isLeft || e.isLeft) Left("Zero divisor") else {
      val a = incorrectFractionCheck(p)
      val b = incorrectFractionCheck(q)
      if (a.isLeft || b.isLeft) Left("Invalid input") else {

        val result: (Int, Int) = (p._1 * q._2, p._2 * q._1)
        val resultCheck = incorrectFractionCheck(result)
        if (resultCheck.isLeft) Left("Improper result") else {
          @tailrec
          def euclideanAlgorithmFractionReduction(xy: (Int, Int)): Int = {
            if (xy._2 % xy._1 == 0) xy._1 else {
              euclideanAlgorithmFractionReduction((xy._2 % xy._1, xy._1))
            }
          }

          val nod = euclideanAlgorithmFractionReduction(result)
          Right((result._1 / nod, result._2 / nod))
        }
      }
    }
  }

  require(divide(1, 0)(1, 2) == Left("Zero divisor"))
  require(divide(1, 2)(1, 0) == Left("Zero divisor"))
  require(divide(1, 2)(0, 2) == Left("Zero divisor"))
  require(divide(3, 4)(1, 10) == Left("Improper result"))
  require(divide(1, 2)(1, 2) == Left("Improper result"))
  require(divide(2, 1)(1, 7) == Left("Invalid input"))
  require(divide(1, 2)(7, 1) == Left("Invalid input"))
  require(divide(1, 1)(2, 2) == Left("Invalid input"))
  require(divide(2, 1)(3, 1) == Left("Invalid input"))
  require(divide(1, 2)(2, 3) == Right((3, 4)))
  require(divide(-1, 2)(2, 3) == Right((-3, 4)))

  def foo(options: List[Option[Int]]): List[Int] = {
    options.collect {
      case Some(v) => v
    }
  }

  foo(List(None, Some(5), Some(12), None))

  val func : Int => String = {
    println("initialized func")
    "Number is " + _.toString
  }
  def func2(a:Int) = {
    println("initialized func2")
    "Number is " + a.toString
  }

  }
