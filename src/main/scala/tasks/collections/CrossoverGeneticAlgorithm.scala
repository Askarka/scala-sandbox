package tasks.collections

import scala.annotation.tailrec

object CrossoverGeneticAlgorithm extends App {
  val points: List[Int] = List(1, 3) // точки кроссинговера
  val chr1: List[Char] = List('x', 'x', 'x', 'x', 'x') // первая хромосома
  val chr2: List[Char] = List('y', 'y', 'y', 'y', 'y') // вторая хромосома

  def crossover(point: Int)(tuple: (List[Char], List[Char])): (List[Char], List[Char]) = {
    (tuple._1.slice(0, point) ++ tuple._2.slice(point, tuple._2.length),
      tuple._2.slice(0, point) ++ tuple._1.slice(point, tuple._2.length))
  }

  @tailrec
  def crossoverOnListOfPoints(points: List[Int])(tuple: (List[Char], List[Char])): (List[Char], List[Char]) = {
    points match {
      case head :: tail => crossoverOnListOfPoints(tail)(crossover(head)(tuple))
      case Nil => tuple
    }
  }

  val result = crossoverOnListOfPoints(points)(chr1, chr2)
  result._1.foreach(print(_))
  println()
  result._2.foreach(print(_))
}
