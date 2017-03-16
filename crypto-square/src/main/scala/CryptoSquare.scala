object CryptoSquare {
  def normalizePlaintext(text: String): String =
    text.filter(_.isLetterOrDigit).map(_.toLower)

  def squareSize(text: String): Int =
    (Math.ceil(Math.sqrt(text.length))).toInt

  def plaintextSegments(text: String): List[String] = {
    val np = normalizePlaintext(text)
    val size = squareSize(np)

    size match {
      case 0 => Nil
      case _ => normalizePlaintext(text).grouped(size).toList
    }
  }

  def ciphertext(text: String): String = convertCiphertext(text, "")

  def normalizedCiphertext(text: String): String = convertCiphertext(text, " ")

  private def convertCiphertext(text: String, sep: String): String =
    plaintextSegments(text)
      .map(_.padTo(squareSize(text), ""))
      .transpose.map(_.mkString)
      .mkString(sep)
      .trim
}
