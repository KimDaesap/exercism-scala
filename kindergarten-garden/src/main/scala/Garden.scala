import Plant.Plant

object Plant extends Enumeration {
  type Plant = Value
  val Radishes, Clover, Grass, Violets = Value
  def get(c: Char): Plant = c match {
    case 'R' => Radishes
    case 'C' => Clover
    case 'G' => Grass
    case 'V' => Violets
  }
}

class Garden(private val children: List[String], private val cups: String) {
  private val Array(xs, ys) = cups.split("\n").map(_.grouped(2).toList)
  private val map = children.sorted.zip(
    List(xs, ys).transpose.flatten.mkString.grouped(4).toList).toMap

  def getPlants(child: String): List[Plant] = {
    map.contains(child) match {
      case false => List[Plant]()
      case true => { for { x <- map(child) } yield Plant.get(x) }.toList
    }
  }
}

object Garden {
  def apply(children: List[String], cups: String): Garden =
    new Garden(children, cups)

  def defaultGarden(cups: String) =
    new Garden(
      List("Alice", "Bob", "Charlie", "David",
        "Eve", "Fred", "Ginny", "Harriet",
        "Ileana", "Joseph", "Kincaid", "Larry"), cups)
}
