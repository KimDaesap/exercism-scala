object Series {
  def slices(step: Int, text: String): List[List[Int]] = {
    text
      .sliding(step, 1)
      .map(str => str.map(ch => ch.asDigit).toList)
      .toList
  }
}
