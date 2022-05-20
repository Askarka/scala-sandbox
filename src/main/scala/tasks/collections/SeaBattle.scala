package tasks.collections

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
    val convenientField: List[List[Boolean]] = field.map(_.toList).toList
    ship.forall(a => convenientField(a._1)(a._2))
  } // определить, можно ли его поставить

  def enrichFleet(fleet: Fleet, name: String, ship: Ship): Fleet = {
    fleet ++ Map(name -> ship)
  } // добавить корабль во флот

  def markUsedCells(field: Field, ship: Ship): Field = {
    val convenientField: List[List[Boolean]] = field.map(_.toList).toList
    ???
  } // пометить клетки, которые занимает добавляемый корабль

  def tryAddShip(game: Game, name: String, ship: Ship): Game = ??? // логика вызовов методов выше

  def main(args: Array[String]): Unit = {
    val sh1 = "2 6" +
      "\n2 7" +
      "\n2 8"

    val sh2 = "2 5" +
      "\n3 5" +
      "\n4 5" +
      "\n5 5"

    val sh3 = "9 9"
    val stringsShipList = List(sh1, sh2, sh3)
    stringsShipList.map(createShip).map(validateShip).foreach(println)

  }

  def createShip(string: String): Ship = {
    string.split(Array(' ', '\n')).grouped(2).toList.map((a => new Point(a.head.toString.toInt, a.last.toString.toInt)))
  }
}
