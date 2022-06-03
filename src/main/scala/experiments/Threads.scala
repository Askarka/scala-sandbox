package experiments

import java.util.concurrent.Executors
import scala.concurrent.{ExecutionContext, ExecutionContextExecutor}

object Threads extends App {

  val ec: ExecutionContextExecutor = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(10))

  def run(): Unit = for (i <- 0 to 10) println(i)

  (0 to 8).foreach { _ => ec.execute(run _)}
}
