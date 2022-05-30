package experiments

import scala.io.StdIn

object CollectionsTests extends App {

  var list = List[Any]()

  while (!list.contains("END")) {
    list = list :+ StdIn.readLine()
  }
  println(list)
}
