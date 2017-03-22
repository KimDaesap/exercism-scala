import Bearing.Bearing

object Bearing extends Enumeration {
  case class Dir(value: (Int, Int)) extends Val {
    def +(that: (Int, Int)) = (that._1 + value._1, that._2 + value._2)
  }

  type Bearing = Dir

  val North = Dir(0, 1)
  val East = Dir(1, 0)
  val South = Dir(0, -1)
  val West = Dir(-1, 0)

  private val indexed = Bearing.values.toIndexedSeq

  def right(dir: Bearing): Bearing =
    indexed((dir.id + 1) % maxId).asInstanceOf[Bearing]

  def left(dir: Bearing): Bearing =
    indexed((dir.id - 1 + maxId) % maxId).asInstanceOf[Bearing]
}

case class Robot(bearing: Bearing, coordinates: (Int, Int)) {
  def advance(): Robot = Robot(bearing, bearing + coordinates)
  def turnRight(): Robot = Robot(Bearing.right(bearing), coordinates)
  def turnLeft(): Robot = Robot(Bearing.left(bearing), coordinates)
  def simulate(xs: String): Robot = {
    var robot = Robot(bearing, coordinates)
    for ( x <- xs ) {
      x match {
        case 'A' => robot = robot.advance
        case 'L' => robot = robot.turnLeft
        case 'R' => robot = robot.turnRight
      }
    }
    robot
  }
}