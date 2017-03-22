
object Isogram {
  def isIsogram(s: String): Boolean = {
    val normal = s.filter(c => c.isLetter).toLowerCase
    def loop(xs: List[Char]): Boolean = xs match {
      case Nil => true
      case h :: t => if (t.contains(h) == false) loop(t) else false
    }
    loop(normal.toList)
  }
}