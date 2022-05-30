import tasks.classes.aliasesAndComponents.Task1.{StringVect, Vect}
import tasks.classes.aliasesAndComponents.Task1.Vect.Aux




final case class BoolVect64(values: Long) extends AnyVal with Vect {
  type Item = Boolean

  def length = 64

  def get(index: Int): Boolean = ((values >> index) & 1) == 1.toByte

  def set(index: Int, item: Boolean): Aux[Boolean] =
    if (item) BoolVect64(values | (1L << index))
    else
      BoolVect64(values & ~(1L << index))
}

final case class BoolVect8(values: Byte) extends AnyVal with Vect {
  type Item = Boolean

  def length = 8

  def get(index: Int): Boolean = ((values >> index) & 1) == 1.toByte

  def set(index: Int, item: Boolean): Aux[Boolean] =
    if (item) BoolVect8((values | (1 << index)).toByte)
    else
      BoolVect8((values & ~(1 << index)).toByte)
}

def toList(vect: Vect): List[vect.Item] = (0 until vect.length).foldLeft(List[vect.Item]())(
  (list, index) => list :+ vect.get(index)
)

toList(BoolVect8(7.toByte))
toList(BoolVect8(7.toByte).set(0, false))
"MyNameIsOlegAndThisIsMyCourseOnStepik".length
toList(StringVect("MyNameIsOlegAndThisIsMyCourseOnStepik"))