object DifferenceOfSquares {

  private def square(n: Int) = n * n

  def sumOfSquares(n: Int): Int =
    ((1 to (_: Int))
      andThen (_.map(square))
      andThen (_.sum))(n)

  def squareOfSum(n: Int): Int =
    ((1 to (_: Int))
      andThen (_.sum)
      andThen (square))(n)

  def differenceOfSquares(n: Int): Int =
    squareOfSum(n) - sumOfSquares(n)
}
