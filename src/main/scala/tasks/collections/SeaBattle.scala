package tasks.collections

import scala.io.StdIn

object Naval {
  type Point = (Int, Int)
  type Field = Vector[Vector[Boolean]]
  type Ship = List[Point]
  type Fleet = Map[String, Ship]
  type Game = (Field, Fleet)
}

object Lesson {
  val field: Vector[Vector[Boolean]] = Vector.fill(10)(Vector.fill(10)(false))
}

object SeaBattle {

  import Naval.{Point, Field, Ship, Fleet, Game}
  import Lesson.field

  def validateShip(ship: Ship): Boolean = {
    def matching(acc: Int, x: Int): Int = (acc: Int, x: Int) match {
      case (_, n) if (n < 0 && n > 9) => println(1)
        -2
      case (-2, _) => -2
      case (-1, n) => n
      case (n, k) if k == n + 1 => k
      case _ => -2
    }

    ship match {
      case ship if ship.length >= 5 => false
      case ship if ship.length == 1 => true
      case head :: tail if !(tail.forall(a => a._1 == head._1) ^ tail.forall((a) => a._2 == head._2)) => false
      case head :: tail if tail.forall(a => a._1 == head._1) => if (
        (head :: tail).flatMap(b => List(b._2)).sorted.foldLeft(-1)(matching) < 0) false else true
      case head :: tail if tail.forall(a => a._2 == head._2) => if (
        (head :: tail).flatMap(b => List(b._1)).sorted.foldLeft(-1)(matching) < 0) false else true
      case _ => false
    }
  } // определить, подходит ли корабль по своим характеристикам

  def validatePosition(ship: Ship, field: Field): Boolean = {
    ship.forall(a => field(a._1)(a._2))
  } // определить, можно ли его поставить

  def enrichFleet(fleet: Fleet, name: String, ship: Ship): Fleet = {
    fleet ++ Map(name -> ship)
  } // добавить корабль во флот

  def markUsedCells(field: Field, ship: Ship): Field = {
    field.foldLeft(Vector[Vector[Boolean]]())(
      (a, b) => a :+ b.foldLeft(Vector[Boolean]())
      ((x, y) => if (
        y ||
          ship.contains((a.length - 1, x.length - 1)) ||
          ship.contains((a.length - 1, x.length)) ||
          ship.contains((a.length - 1, x.length + 1)) ||
          ship.contains((a.length, x.length - 1)) ||
          ship.contains((a.length, x.length)) ||
          ship.contains((a.length, x.length + 1)) ||
          ship.contains((a.length + 1, x.length - 1)) ||
          ship.contains((a.length + 1, x.length)) ||
          ship.contains((a.length + 1, x.length + 1))

      ) x :+ true else x :+ false))
  } // пометить клетки, которые занимает добавляемый корабль

  def tryAddShip(game: Game, name: String, ship: Ship): Game = {
    if (!validateShip(ship) || !validatePosition(ship, game._1))game
    else {
      new Game(markUsedCells(game._1, ship), enrichFleet(game._2, name, ship))
    }
  } // логика вызовов методов выше

  def main(args: Array[String]): Unit = {
    val potentialShipsAmount = StdIn.readLine().toInt

    def play(game: Game, ships: Int): Game = {
      ships match {
        case 0 => game
        case n: Int => {
          val name = StdIn.readLine().toInt
          play(tryAddShip(game, ???, ???), n - 1)
        }
      }
    }

    play((field, Map[String, Ship]()), potentialShipsAmount)
  }
}
