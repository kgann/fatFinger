import fatfinger.FatFinger._

object Example {
  def main(args: Array[String]) = {
    val sample = "testing it down the street"
    val data = List(
      "testing it down thw street",
      "trsting it down",
      "stressing it down a creek",
      "trdt",
      "twde",
      "mqpavql",
      "treating it good",
      "",
      " "
    )
    println(sample + ":")
    data map{ s => s + " -> " + probability(sample, s) + "%" } foreach println
  }
}

