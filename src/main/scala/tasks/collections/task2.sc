import tasks.collections.Naval.{Point, Ship}

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
def createShip(string: String): Ship = {
  string.split(Array(' ', '\n')).grouped(2).toList.map((a => new Point(a.head.toString.toInt, a.last.toString.toInt)))
}
stringsShipList.map(createShip)
