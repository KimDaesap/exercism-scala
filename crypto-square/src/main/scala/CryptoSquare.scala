object CryptoSquare {
  def normalizePlaintext(text: String): String = {
    val result = text.filter(_.isLetterOrDigit).map(_.toLower)
    println(s"normalizePlaintext: $result")
    result
  }

  def squareSize(text: String): Int = {
    val result = (Math.ceil(Math.sqrt(text.length))).toInt
    println(s"squareSize: $result")
    result
  }

  def plaintextSegments(text: String): List[String] = {
    val np = normalizePlaintext(text)
    val size = squareSize(np)
    val result = np.grouped(size).toList
    println(s"plaintextSegments:\n${result.mkString("\n")}")
    result
  }

  def ciphertext(text: String): String = {
    val ps = plaintextSegments(text)
    val l = squareSize(text)
    val result = ps.map(_.padTo(l, "")).transpose.map(_.mkString).mkString
    println(s"ciphertext: $result")
    result
  }

  def normalizedCiphertext(text: String): String = {
    // plaintextSegments
    // ciphertext
    // plaintextSegments


    val result = plaintextSegments((ciphertext(text))).mkString(" ")
    println(s"normalizedCiphertext: $result")
    result
  }
}
