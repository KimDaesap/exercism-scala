case class Matrix(text: String) {
  val matrix = text
    .split('\n')
    .map(_.split(' ').map(_.toInt).toVector)
    .toVector

  def rows(row: Int): Vector[Int] =
    matrix.apply(row)

  def cols(col: Int): Vector[Int] =
    matrix.transpose.apply(col)
}

