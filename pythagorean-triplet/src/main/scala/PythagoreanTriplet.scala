object PythagoreanTriplet {
  def pythagoreanTriplets(start: Int, end: Int): Seq[(Int, Int, Int)] = {
    for {
      a <- (start to end)
      b <- (a to end)
      c <- (b to end)
      if isPythagorean(a,b,c)
    } yield (a,b,c)
  }

  def isPythagorean(tuple: (Int, Int, Int)): Boolean = {
    val List(a,b,c) = List(tuple._1, tuple._2, tuple._3).sorted
    a * a + b * b == c * c
  }
}
