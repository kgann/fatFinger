package fatfinger

object FatFinger {
  val qwertyMap: Map[Char, Tuple2[Int, Int]] = Map(
    'q' -> (1, 1),
    'w' -> (2, 1),
    'e' -> (3, 1),
    'r' -> (4, 1),
    't' -> (5, 1),
    'y' -> (6, 1),
    'u' -> (7, 1),
    'i' -> (8, 1),
    'o' -> (9, 1),
    'p' -> (10, 1),

    'a' -> (1, 2),
    's' -> (2, 2),
    'd' -> (3, 2),
    'f' -> (4, 2),
    'g' -> (5, 2),
    'h' -> (6, 2),
    'j' -> (7, 2),
    'k' -> (8, 2),
    'l' -> (9, 2),

    'z' -> (1, 3),
    'x' -> (2, 3),
    'c' -> (3, 3),
    'v' -> (4, 3),
    'b' -> (5, 3),
    'n' -> (6, 3),
    'm' -> (7, 3),

    ' ' -> (5, 4)
  )

  private final val qwertyMaxDistance = charDistance('q', ' ')

  def probability(s1: String, s2: String) = {
    (1 - (stringDistance(s1, s2) / (scala.math.max(s1.length, s2.length) * qwertyMaxDistance))) * 100 match {
      case p if p < 0 => 0
      case p          => p
    }
  }

  private def stringDistance(s1: String, s2: String) = {
    s1.zip(s2).foldLeft(0.0){ (accum, tup) =>
      accum + charDistance(tup)
    } + (scala.math.abs(s1.size - s2.size) * qwertyMaxDistance) + scala.math.abs(s1.size - s2.size)
  }

  private def charDistance(tup: Tuple2[Char, Char]) = {
    coordinates(tup._1, tup._2) match {
      case ((x1, y1), (x2, y2)) => {
        if(scala.math.abs(x1 - x2) == 1 && scala.math.abs(y1 - y2) == 1)
          1
        else
          math.sqrt(scala.math.pow(x1 - x2, 2) + scala.math.pow(y1 - y2, 2))
      }
    }
  }

  private def coordinates(tup: Tuple2[Char, Char]) = (qwertyMap(tup._1.toLower), qwertyMap(tup._2.toLower))

}//FatFinger
