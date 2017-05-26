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
    val sorted = tuple match { case (a,b,c) => List(a,b,c).sorted }
    sorted match { case List(a, b, c) => a * a + b * b == c * c }
  }
}
