import Bearing.Bearing

/**
  * Created by daesapkim on 2017. 3. 22..
  */
object Bearing extends Enumeration {
  type Bearing = (Int, Int)
  val North = (0, -1)
  val East = (1, 0)
  val South = (-1, 0)
  val West = (0, 1)
}

case class Robot(bearing: Bearing, coordinates: (Int, Int)) {
  def advance(): Robot = ???
  def turnRight(): Robot = ???
  def turnLeft(): Robot = ???
  def simulate(xs: String): Robot = ???
}


class PrevNextEnum extends Enumeration {

  lazy val prevOf = {
    val list = values.toList
    val map = list.tail.zip(list).toMap
    v:Value => map.getOrElse(v, values.last)
  }
  lazy val nextOf = {
    val list = values.toList
    val map = list.zip(list.tail).toMap
    v:Value => map.getOrElse(v, values.head)
  }
}

object Nums extends PrevNextEnum {
  type Nums = Value
  val One, Two, Three = Value
}
