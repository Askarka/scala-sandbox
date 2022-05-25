package tasks.classes

trait StringProcessor {
  def process(input: String): String
}

object StringProcessorImplementations {
  val tokenDeleter: StringProcessor = (input: String) => input.filter(ch => ch != ',' && ch != ':' && ch != ';')
  val shortener: StringProcessor = (input: String) => if (input.length > 20) input.slice(0, 20) + "..." else input
  val toLowerConvertor: StringProcessor = (input: String) => input.toLowerCase

  def main(array: Array[String]): Unit = {
    val testString = "This is a Wonderful Test!"
    print(toLowerConvertor.process(shortener.process(tokenDeleter.process(testString))))
  }
}
