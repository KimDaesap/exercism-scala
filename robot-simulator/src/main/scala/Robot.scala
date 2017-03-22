import Bearing.Bearing

object Bearing extends Enumeration {
  case class Vector(value: (Int, Int)) extends Val {
    def +(that: (Int, Int)) = (that._1 + value._1, that._2 + value._2)
  }

  type Bearing = Vector
  val North = Vector(0, 1)
  val East = Vector(1, 0)
  val South = Vector(0, -1)
  val West = Vector(-1, 0)

  private val indexed = Bearing.values.toIndexedSeq

  def right(dir: Bearing): Bearing =
    indexed((dir.id + 1) % maxId).asInstanceOf[Bearing]

  def left(dir: Bearing): Bearing =
    indexed((dir.id - 1 + maxId) % maxId).asInstanceOf[Bearing]
}

case class Robot(bearing: Bearing, coordinates: (Int, Int)) {
  def advance(): Robot = this.copy(coordinates = bearing + coordinates)
  def turnRight(): Robot = this.copy(bearing = Bearing.right(bearing))
  def turnLeft(): Robot = this.copy(bearing = Bearing.left(bearing))
  def simulate(xs: String): Robot =
    xs.foldLeft(this) {
      (acc, x) => x match {
        case 'A' => acc.advance
        case 'L' => acc.turnLeft
        case 'R' => acc.turnRight
    }
  }
}