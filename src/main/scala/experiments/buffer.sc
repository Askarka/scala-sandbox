val a = Option(2)
val b = Option(2)
val c = Some(4)
val d: Option[Any] = for {
  a1 <- a
  b1 <- b
  c1 <- c
}yield a1 * b1 * c1