import fatfinger.FatFinger._

object Test {
  def main(args: Array[String]) = {
    val sample = "testing"
    val data = List(
      "testing",
      "twsting",
      "trdt",
      "twde",
      "sslso"
    )
    data.foreach{ s => println(probability(sample, s))}
  }
}

