for {
  x <- Some(1)
  y <- None
} yield (x, y)
for {
  x <- Some(List(2))
  y <- Some(List(1, 2, 3, 4))
} yield x ++ y
val nums = List(2, 5, 1 ,7, 4)

val nums1 = for {
  x <- nums
  y <- 1 to x if y > 3
} yield y

val nums2 = for {
  x <- nums
  y <- 1 to x if y > 3
  y2 = y * 2
  z <- nums if z < y2
} yield z + y2 - y

val nums3 = nums
  .flatMap(x =>
    (1 to x)
      .withFilter(y => y > 3)
      .map {
        y => val y2 = y * 2
        (y, y2)
      }
      .flatMap { case (y, y2) =>
        nums
          .withFilter(z => z < y2)
          .map(z => z + y2 - y)
      }
  )

