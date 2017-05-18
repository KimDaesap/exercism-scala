
object Sieve {
  def primesUpTo(number: Int): List[Int] = {
    val checkList = new Array[Boolean](number + 1)

    def loop(n: Int, to: Int, ckList: Array[Boolean]): List[Int] = n match {
      case n if n > to => Nil
      case n if !ckList(n) => {
        (n to number by n).foreach { ckList(_) = true }
        n :: loop(n + 1, number, ckList)
      }
      case _ => loop(n + 1, number, ckList)
    }

    loop(2, number, checkList)
  }
}
