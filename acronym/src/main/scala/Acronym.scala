object Acronym {
  def isSeparates(lc: Char, rc: Char): Boolean =
    lc == ' ' || lc == '-' || (lc.isLower && rc.isUpper)

  def abbreviate(phrase: String): String = {
    def loop(prev: Char, text: Seq[Char]): String = {
      text match {
        case Seq() => ""
        case h +: t =>
          if (isSeparates(prev, h)) h.toUpper + loop(h, t)
          else loop(h, t)
      }
    }

    loop(' ', phrase)
  }
}
