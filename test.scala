import fatfinger.FatFinger._

object Test {
  def main(args: Array[String]) = {
    val sample = "testing it down"
    val data = List(
      "testing it down",
      "trsting it down",
      "trdt",
      "twde",
      "mqpavql",
      "treating it good"
    )
    data map(probability(sample, _)) foreach println
    // data.foreach{ s => println(probability(sample, s))}
  }
}

