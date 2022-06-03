package exam

import scala.math.{atan2, cos, pow, sin, sqrt}

object Task1 {
  abstract class Point(a: Double, b: Double)
  case class PointInCartesian(x: Double, y: Double) extends Point(x, y) {
    def toPolar: PointInPolar = {
      PointInPolar(sqrt(pow(this.x, 2) + pow(this.y, 2)), atan2(this.x, this.y))
    }
  }
  case class PointInPolar(r: Double, t: Double) extends Point(r, t) {
    def toCartesian: PointInCartesian = {
      PointInCartesian(r * cos(t), r * sin(t))
    }
  }
}
