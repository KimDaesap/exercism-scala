object RunLengthEncoding {

  def encode(str: String): String = str match {
    case "" => ""
    case t => {
      val char = t.head
      val (same, remains) = t.span(_ == char)
      val lt = if (same.length > 1) same.length.toString else ""
      lt + char + encode(remains)
    }
  }

  def decode(str: String): String = str match {
    case "" => ""
    case t => {
      val (lt, dt) = t.span(_.isDigit)
      val l = if (lt == "") 1 else lt.toInt
      val (char, remains) = dt.splitAt(1)
      char * l + decode(remains)
    }
  }
}

