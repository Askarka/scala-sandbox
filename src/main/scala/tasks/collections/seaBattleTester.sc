import tasks.collections.Naval.{Field, Point, Ship}

val p1: Point = (2, 3)
val p2: Point = (2, 4)
val ship: Ship = List((2, 3), (2, 4))

ship.contains(p2)

for {
  x <- -1 to 1
  y <- -1 to 1
  z = (x, y)
} yield z