object RailFenceCipher {

  def encode(text: String, depth: Int): String = {
    import scala.collection.mutable.SortedMap

    def go(ts: Seq[Char], level: Int, factor: Int, map: SortedMap[Int, String]): SortedMap[Int, String] = {
      ts match {
        case Seq() => map
        case h +: t =>
          val nf = if (level == 1) 1
          else if (level >= (depth)) -1
          else factor

          map(level) = map.getOrElse(level, "") + h
          go(t, level + nf, nf, map)
      }
    }

    go(text, 1, 1, SortedMap())
      .foldLeft("")((acc, tp) => acc + tp._2)
  }

  def decode(text: String, depth: Int): String = {

    ???
  }
}