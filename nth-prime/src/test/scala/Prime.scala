object Prime {
  def nth(n: Int): Option[Int] = {
    lazy val primes: Stream[Int] =
      2 #:: Stream.from(3).filterNot(n => primes.takeWhile(_ <= math.sqrt(n)).exists(n % _ == 0))
    primes.take(n).lastOption
  }
}
