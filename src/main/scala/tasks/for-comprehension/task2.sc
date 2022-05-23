def service1: Either[String, Double]
def service2(res1: Double): Either[String, Int]
def service3: String
def service4(res1: Double, res2: Int, res3: String): Either[String, String]

def result = for {
  x <- service1
  y <- service2(x)
  z = service3
  h <- service4(x, y, z)
} yield h

