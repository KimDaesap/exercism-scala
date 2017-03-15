
class Bob {
  def hey(message: String): String = {
    message match {
      case m if (m.toUpperCase == m && m.toLowerCase != m) => "Whoa, chill out!"
      case m if (m.endsWith("?")) => "Sure."
      case m if (m.trim.isEmpty) => "Fine. Be that way!"
      case _ => "Whatever."
    }
  }

}
