
case class Phrase(text: String) {
  def wordCount: Map[String, Int] = {
    text
      .toLowerCase
      .filterNot(c => ":!&@$%^&.".contains(c))
      .split("[ ,]+")
      .groupBy(identity)
      .map(t => (t._1, t._2.length))
  }
}
