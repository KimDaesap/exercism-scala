object CryptoSquare {
  def normalizePlaintext(text: String): String =
    text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase

  def squareSize(text: String): Int =
    (Math.sqrt(text.length) + 0.9).toInt

  def plaintextSegments(text: String): List[String] =
    normalizePlaintext(text).grouped(squareSize(text)).toList

  def ciphertext(text: String): String = {
    val ps = plaintextSegments(text)
    val l = squareSize(text)
    ps.map(_.padTo(l, "")).transpose.map(_.mkString).mkString
  }

  def normalizedCiphertext(text: String): String = {
    ""
  }
}
