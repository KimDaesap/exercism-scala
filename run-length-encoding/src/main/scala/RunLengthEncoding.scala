object RunLengthEncoding {

  def encode(str: String): String = {
    def loop(xs: Seq[Char], acc: String): String = {
      xs match {
        case Nil => acc
        case h :: t => {
          val remains = t.dropWhile(_ == h)
          val l = xs.length - remains.length
          val n = if (l > 1) l.toString else ""
          loop(remains, acc + n + h)
        }
      }
    }

    loop(str, "")
  }

  def decode(str: String): String = {
    ???
  }
}


/*

val input = "12WB12W3B24WB"

val (length, remains) = input.span(_.isDigit)
var l: Int = length match { case "" => 1; case x => x.toInt }

"TEST:" + (remains.take(1) * l)

*/