case class Ocr(text: String) {
  val digits = Map(
    " _ | ||_|   " -> "0",
    "     |  |   " -> "1",
    " _  _||_    " -> "2",
    " _  _| _|   " -> "3",
    "   |_|  |   " -> "4",
    " _ |_  _|   " -> "5",
    " _ |_ |_|   " -> "6",
    " _   |  |   " -> "7",
    " _ |_||_|   " -> "8",
    " _ |_| _|   " -> "9"
  ).withDefaultValue("?")

  def convert: String = {
    def toDigit(line: Seq[String]): String = line
      .map(_.grouped(3).toSeq)
      .transpose
      .map(ts => digits(ts.mkString))
      .mkString

    text
      .split("\n")
      .grouped(4)
      .map(toDigit(_))
      .mkString(",")
  }
}