package tasks.collections

final class DiffListImpl[A](listFunc: List[A] => List[A]) extends DiffList[A](listFunc) {
  override def prepend(s: List[A]): DiffList[A] = ???

  override def append(s: List[A]): DiffList[A] = ???

  override def result: List[A] = ???
}
