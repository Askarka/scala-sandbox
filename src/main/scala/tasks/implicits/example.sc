final case class Ratio private[Ratio](num: BigInt, den: BigInt)

object Ratio{
  def make(num: BigInt, den: BigInt): Ratio = {
    val gcd = num.gcd(den)
    Ratio(num / gcd, den / gcd)
  }
}

implicit class RatioOps[T](val num: T){
  def \\(den: BigInt)(implicit f: T => BigInt): Ratio = Ratio.make(num, den)
}

2 \\ 4

object Ops {
  implicit class IntOps1(val x: Int) extends AnyVal {
    def ::(y: Int): Int = (x.toString + y.toString).toInt
  }
//  implicit class IntOps2(val x: Int) extends AnyVal {
//    def :: (y: Int): String = 3 + " :: " + 4
//  }
}

object imp extends App {
  import Ops._
  val res = 3 :: 4
  println(res)
}