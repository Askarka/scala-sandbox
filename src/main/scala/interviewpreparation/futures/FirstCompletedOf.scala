package interviewpreparation.futures

import cats.data.OptionT

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object FirstCompletedOf extends App {
  val a = Future { Thread.sleep(200); 1 }
  val b = Future { Thread.sleep(200); 2 }
  val c = Future { Thread.sleep(200); 3 }

  val result1 = Future.firstCompletedOf(Seq(a, b, c))
  val result2 = Future.firstCompletedOf(Seq(a, b, c))
  val result3 = Future.firstCompletedOf(Seq(a, b, c))
  result1.onComplete(println)
  result2.onComplete(println)
  result3.onComplete(println)
  Thread.sleep(184)
  OptionT
}
