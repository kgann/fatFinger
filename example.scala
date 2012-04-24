import fatfinger._

object Example {
  def main(args: Array[String]) = {
    val sample = "testing it down the street"
    val data = List(
      "testing it down the street",
      "testing it down thw street",
      "trsting it down",
      "stressing it down the street",
      "turf wars",
      "reality tv program",
      "breaking up the band",
      "salmon salad",
      "",
      " "
    )
    println(sample + ":")
    data map{ s => s + " -> " + FatFinger.probability(sample, s) + "%" } foreach println
  }
}

