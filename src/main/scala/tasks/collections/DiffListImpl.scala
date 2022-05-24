package tasks.collections

import scala.collection.immutable.Nil

final class DiffListImpl[A](listFunc: List[A] => List[A]) extends DiffList[A](listFunc) {
  override def prepend(s: List[A]): DiffList[A] = new DiffListImpl[A](listFunc.andThen(a => s ++ a))

  override def append(s: List[A]): DiffList[A] = new DiffListImpl[A](listFunc.andThen(a => a ++ s))

  override def result: List[A] = listFunc(Nil)
}
