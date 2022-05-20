package tasks.collections

import scala.io.StdIn

object Main2 extends App {
  println(LazyList.continually(StdIn.readLine())
    .takeWhile(string => string != "END")
    .grouped(2)
    .filter(_.length != 1)
    .map(_.last)
    .map(_.toInt * 2)
    .sum)
}
