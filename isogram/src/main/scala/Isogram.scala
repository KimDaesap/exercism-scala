object Isogram {
  def isIsogram(s: String): Boolean = {
    val normal = s.filter(c => c.isLetter).toLowerCase
    normal.distinct == normal
  }
}