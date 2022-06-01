package interviewpreparation.futures

import scala.concurrent.Future

object Result extends App {
  import scala.concurrent.Await
  import scala.concurrent.duration.Duration
  import scala.concurrent.ExecutionContext.Implicits.global

  val greetingFuture = Future {
    Thread.sleep(1000)
    println("calculating...")
    "Hello"
  }

  println("Friend")

  val greeting = Await.result(greetingFuture, Duration.Inf)

  println(s"Result: $greeting")
}
