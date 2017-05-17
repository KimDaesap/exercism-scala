
object SecretHandshake {
  private val funcs = List(
    (xs: List[String]) => xs :+ "wink",
    (xs: List[String]) => xs :+ "double blink",
    (xs: List[String]) => xs :+ "close your eyes",
    (xs: List[String]) => xs :+ "jump",
    (xs: List[String]) => xs.reverse
  )

  def handshake(number: Int): List[String] = handshake(number.toBinaryString)

  def handshake(binary: String): List[String] = {

    def loop(seq: Seq[Char], index: Int, list: List[String]): List[String] = {
      val next = index + 1
      seq match {
        case h +: t => h match {
          case '1' => loop(seq.tail, next, funcs(index)(list))
          case '0' => loop(seq.tail, next, list)
          case _ => Nil
        }
        case _ => list
      }
    }

    loop(binary.reverse, 0, Nil)
  }
}