case class Matrix(rows: Vector[Vector[Int]]) {
  def cols(col: Int): Vector[Int] = rows.transpose.apply(col)
}

object Matrix {
 def apply(text: String): Matrix ={
   Matrix(text
     .split('\n')
     .map(_.split(' ').map(_.toInt).toVector)
     .toVector)
 }
}