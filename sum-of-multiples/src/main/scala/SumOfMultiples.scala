object SumOfMultiples {
  def sumOfMultiples(factors: Set[Int], limit: Int): Int = {
    def loop(f: Int, m: Int, acc: List[Int], limit: Int): List[Int] = {
      val x = f + m
      if (x < limit) loop(f, x, x :: acc, limit)
      else acc
    }

    { for {f <- factors
        fs = loop(f, 0, Nil, limit)
      } yield fs
    }.flatten.sum
  }
}

