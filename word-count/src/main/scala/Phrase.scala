
case class Phrase(text: String) {
  def wordCount: Map[String, Int] = {
    text
      .toLowerCase
      .filterNot(c => ":!&@$%^&.".contains(c))
      .split("[ ,]+")
      .groupBy(identity)
      .mapValues(_.length)
  }
}
