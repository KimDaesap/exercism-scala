object SumOfMultiples {
  def sumOfMultiples(factors: Set[Int], limit: Int): Int = {
    (1 until limit).flatMap(x =>
      if (factors.exists(ft => x % ft == 0)) Some(x)
      else None ).sum
  }
}

