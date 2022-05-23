import tasks.collections.Naval.{Field, Point, Ship}
val ship = List(new Point(1, 2), new Point(1, 3), new Point(1, 4))
//def markUsedCells(field: Field, ship: Ship): Field = {
//  def buildField(field: Field = Vector.fill(10)(Vector.empty), ship: Ship, currentPoint: (Int, Int) = (0, 0)): Field = {
//    if (field.length <= 10) {
//
//      markUsedCells(Vector[Vector[Boolean]](), ship,
//        if (currentPoint._2 == 10)
//          (currentPoint._1 + 1, 0)
//      )
//    } else field
////    buildField()
//}

//markUsedCells()

