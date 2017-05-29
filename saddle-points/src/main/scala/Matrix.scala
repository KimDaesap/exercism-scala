case class Matrix(matrix: List[List[Int]]) {
  private val rowsMax = matrix.map(_.max)
  private val columnsMin =  matrix.transpose.map(_.min)

  def saddlePoints: Set[(Int, Int)] = {
    val ret = for {
      y <- 0 until matrix.size
      x <- 0 until matrix(y).size
      if matrix(y)(x) == rowsMax(y) && matrix(y)(x) == columnsMin(x)
    } yield (y, x)
    ret.toSet
  }
}
