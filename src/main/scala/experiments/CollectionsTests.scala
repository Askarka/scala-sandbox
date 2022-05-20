package experiments

import scala.io.StdIn

object CollectionsTests extends App {

  var list = List[Any]()

  while (!list.contains("END")) {
    list = list.appended(StdIn.readLine())
  }
  println(list)
}
