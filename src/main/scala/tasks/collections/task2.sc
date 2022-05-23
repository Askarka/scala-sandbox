import tasks.collections.Naval.{Field, Ship}
def markUsedCells(field: Field, ship: Ship) = {
  field.foldLeft(Vector[Vector[(Boolean, Int, Int)]]())(
    (a, b) => a:+ b.foldLeft(Vector[(Boolean, Int, Int)]())
    ((x, y) => if (y || ship.contains((a.length, x.length))) x :+ (true, a.length, x.length) else x :+ (false, a.length, x.length)))
}
val sh1 = "2 6" +
  "\n2 7" +
  "\n2 8"
val sh2 = "2 5" +
  "\n3 5" +
  "\n4 5" +
  "\n5 5"
val field: Vector[Vector[Boolean]] = Vector.fill(10)(Vector.fill(10)(false))
val sh3 = "9 9"
val stringsShipList = List(sh1, sh2, sh3)

val sh1 = "2 6" +
  "\n2 7" +
  "\n2 8"

val sh2 = "2 5" +
  "\n3 5" +
  "\n4 5" +
  "\n5 5"

val sh3 = "9 9"
val stringsShipList = List(sh1, sh2, sh3)
