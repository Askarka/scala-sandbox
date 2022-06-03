//package exam
//
//import cats._
//import cats.data.OptionT
//import cats.syntax.either._
//
//impor
//object Task2 {
//  type Func[A, B] = A => B
//
//  implicit def MyMonad[F[_]](implicit
//      F: Monad[F]
//  ): Monad[Func[F, *]] = {
//    new Monad[Func[F, *]] {
//      def pure[A](a: A): Func[F, A] = Func(F.pure(Some(a)))
//      def flatMap[A, B](
//          fa: OptionT[F, A]
//      )(f: A => Func[F, B]): Func[F, B] =
//        Func {
//          F.flatMap(fa.value) {
//            case None    => F.pure(None)
//            case Some(a) => f(a).value
//          }
//        }
//
//      def tailRecM[A, B](
//          a: A
//      )(f: A => Func[F, Either[A, B]]): Func[F, B] =
//        Func {
//          F.tailRecM(a)(a0 =>
//            F.map(f(a0).value) {
//              case None     => Either.right[A, Option[B]](None)
//              case Some(b0) => b0.map(Some(_))
//            }
//          )
//        }
//    }
//  }
//}
