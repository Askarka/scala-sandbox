package tasks.collections

abstract class DiffList[A](calculate: List[A] => List[A]) {
  def prepend(s: List[A]): DiffList[A]

  def append(s: List[A]): DiffList[A]

  def result: List[A]
}
