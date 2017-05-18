
object Sieve {
  def primesUpTo(number: Int): List[Int] = {
    val checkList = new Array[Boolean](number + 1)

    def isPrime(n: Int): Boolean = !((2 until n) exists (n % _ == 0))

    def loop(n: Int, to: Int, ckList: Array[Boolean]): List[Int] = {
      n match {
        case n if n > to => Nil
        case n if !ckList(n) =>
          (n to number by n).foreach { checkList(_) }
          if (isPrime(n)) n :: loop(n + 1, number, ckList)
          else loop(n + 1, number, ckList)
        case _ => loop(n + 1, number, ckList)
      }
    }

    loop(2, number, checkList)
  }
}
