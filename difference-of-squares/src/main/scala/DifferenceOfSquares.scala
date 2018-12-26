object DifferenceOfSquares {

  def sumOfSquares(n: Int): Int =
    (1 to n).foldLeft(0)((acc, x) => x * x + acc)

  def squareOfSum(n: Int): Int = {
    val sum = (1 to n).sum
    sum * sum
  }

  def differenceOfSquares(n: Int): Int =
    squareOfSum(n) - sumOfSquares(n)
}
