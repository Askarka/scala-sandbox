package tasks.classes

import scala.io.StdIn

object FacedString {
  def apply(input: String) = s"*_*$input*_*"

  def unapply(arg: String): Option[String] =
    if (arg.startsWith("*_*") && arg.endsWith("*_*")) Some(arg.slice(3, arg.length - 3)) else None
}

object Main {
  def main(args: Array[String]): Unit = {
    StdIn.readLine() match {
      case FacedString(str) => println(str)
      case _ => println("Could not recognize string")
    }
  }
}