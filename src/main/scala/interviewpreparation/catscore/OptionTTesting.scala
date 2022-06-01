package interviewpreparation.catscore

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object OptionTTesting extends App {
  import scala.concurrent.Future
  import scala.concurrent.ExecutionContext.Implicits.global
  val customGreeting: Future[Option[String]] = Future.successful(Some("welcome back, Lola"))
  val excitedGreeting: Future[Option[String]] = customGreeting.map(_.map(_ + "!"))
  val hasWelcome: Future[Option[String]] = customGreeting.map(_.filter(_.contains("welcome")))
  val noWelcome: Future[Option[String]] = customGreeting.map(_.filterNot(_.contains("welcome")))
  val withFallback: Future[String] = customGreeting.map(_.getOrElse("hello, there!"))

  import cats.data.OptionT
  import cats.implicits._
  val customGreetingT: OptionT[Future, String] = OptionT(customGreeting)
  val excitedGreetingT: OptionT[Future, String] = customGreetingT.map(_ + "!")
  val withWelcome: OptionT[Future, String] = customGreetingT.filter(_.contains("welcome"))
  val noWelcomeT: OptionT[Future, String] = customGreetingT.filterNot(_.contains("welcome"))
  val withFallbackT: Future[String] = customGreetingT.getOrElse("hello, there!")

  val greetingFO: Future[Option[String]] = Future.successful(Some("Hello"))
  val firstnameF: Future[String] = Future.successful("Jane")
  val lastnameO: Option[String] = Some("Doe")
  val ot: OptionT[Future, String] = for {
    g <- OptionT(greetingFO)
    f <- OptionT.liftF(firstnameF)
    l <- OptionT.fromOption[Future](lastnameO)
  } yield s"$g $f $l"
  val result: Future[Option[String]] = ot.value // Future(Some("Hello Jane Doe"))
  ot.map(println)
  result.onComplete(println)
  Thread.sleep(1000)
}
