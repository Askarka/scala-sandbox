package interviewpreparation.futures

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object OnComplete extends App {
  val a: Future[String] = Future { Thread.sleep(1 * 10);
    "Delayed result"
//    throw new Exception("tralala")
  }

//  a.onComplete {
//    case Success(result: String) => println(result)
//    case Failure(ex: Exception) => println(s"Operation failed with $ex")
//  }
  Thread.sleep(1000)
  println("Immediate result") // отобразится до Delayed result
}
