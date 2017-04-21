object SumOfMultiples {
  def sumOfMultiples(factors: Set[Int], limit: Int): Int = {
    val xs = factors.foldLeft(Set[Int]()) {
      (acc, x) => acc ++ (x until limit by x) }
    xs.sum
  }
}