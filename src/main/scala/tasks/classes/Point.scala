package tasks.classes

class Point(val x: Double, val y: Double, val z: Double)

object Point {
  def apply(x: Double, y: Double, z: Double): Point = {
    new Point(x, y, z)
  }

  def average(list: List[Point]): Point = {
    list match {
      case Nil => Point(0, 0, 0)
      case list => Point(
        list.foldLeft(0d)((n, point) => n + point.x) / list.length,
        list.foldLeft(0d)((n, point) => n + point.y) / list.length,
        list.foldLeft(0d)((n, point) => n + point.z) / list.length,
      )
    }
  }

  def show(point: Point): String = s"${point.x} ${point.y} ${point.z}"
}