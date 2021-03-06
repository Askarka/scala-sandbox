package tasks.classes

trait AbstractBank {
  def a: Char
  def b: Char
  def c: Char
  def d: Char
  def e: Char
  def f: Char
  def issueCredit(): Unit
}
trait BankA extends AbstractBank {
  override val b = 'T'
  override val d = 'R'
  override val f = 'I'
}
trait BankB extends AbstractBank {
  override val a = 'E'
  override val f = 'D'
}
trait BankC extends AbstractBank {
  override val b = 'C'
  override val d = 'D'
}
trait BankD extends AbstractBank {
  override val b = 'C'
  override val c = 'R'
  override val d = 'E'
}
trait BankE extends AbstractBank {
  override val b = 'C'
  override val a = 'I'
  override val e = 'T'
}
class CreditBank
    extends AbstractBank
    with BankA
    with BankB
    with BankC
    with BankD
    with BankE {
  def issueCredit(): Unit = println(
    "" + b + c + d + f + a + e
  ) //for example: a + b + c + d + e + f
}
object Main2 extends App {
  (new CreditBank).issueCredit()
}
