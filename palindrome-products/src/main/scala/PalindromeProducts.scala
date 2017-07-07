case class PalindromeProducts(a: Int, b: Int) {
  implicit val order = Ordering.by((x: (Int, Set[(Int, Int)])) => x._1)

  val map = (
    for {
      i <- (a to b)
      j <- (i to b)
      c = i * j
      if isPalindrome(c)
    } yield c -> (i, j)
  ) groupBy(k => k._1) map {
    case (k, vs) => (k, vs.map(s => s._2).toSet)
  }

  def isPalindrome(n: Int): Boolean = n.toString == n.toString.reverse

  def largest = map.max

  def smallest = map.min
}
