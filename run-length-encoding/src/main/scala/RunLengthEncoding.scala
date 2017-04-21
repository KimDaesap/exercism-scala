object RunLengthEncoding {

  def encode(str: String): String = {
    def loop(xs: String, acc: String): String = {
      xs match {
        case "" => acc
        case t => {
          val char = t.head
          val (left, right) = t.span(_ == char)
          val lt = if (left.length > 1) left.length.toString else ""
          loop(right, acc + lt + char)
        }
      }
    }

    loop(str, "")
  }

  def decode(str: String): String = {
    def loop(xs: String, acc: String): String = {
      xs match {
        case "" => acc
        case t => {
          val (lt, dt) = t.span(_.isDigit)
          val l = if (lt == "") 1 else lt.toInt
          val (char, remains) = dt.splitAt(1)
          loop(remains, acc + char * l)
        }
      }
    }

    loop(str, "")
  }
}

