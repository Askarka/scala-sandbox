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
      case (-2, _) => println(2)
        -2
      case (-1, n) => println(3, n)
        n
      case (n, k) if k == n + 1 => println(4, k)
        k
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

  def validatePosition(ship: Ship, field: Field): Boolean = ??? // определить, можно ли его поставить

  def enrichFleet(fleet: Fleet, name: String, ship: Ship): Fleet = ??? // добавить корабль во флот

  def markUsedCells(field: Field, ship: Ship): Field = ??? // пометить клетки, которые занимает добавляемый корабль

  def tryAddShip(game: Game, name: String, ship: Ship): Game = ??? // логика вызовов методов выше

  def main(args: Array[String]) = {
    val sh1 =
      """1 6
        |1 7
        |1 9""".stripMargin
    val sh2 =
      """2 5
        |3 5
        |4 5
        |4 5""".stripMargin
    val sh3 =
    """9 9"""
    val stringsShipList = List(sh1, sh2, sh3)

//    println(stringsShipList.map(sh =>
//    {validateShip(createShip(sh))
//      println()}
//      ))
  }
  def createShip(string: String): Ship = {
    string.split(Array(' ', '\n')).toList.grouped(2).toList.flatMap(list => List(new Point(list.head.toInt, list.last.toInt)))
  }
}
