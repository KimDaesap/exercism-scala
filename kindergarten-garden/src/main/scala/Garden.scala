import Plant.Plant

object Plant extends Enumeration {
  type Plant = Value
  val Radishes, Clover, Grass, Violets = Value
  def get(c: String): Plant = c match {
    case "R" => Radishes
    case "C" => Clover
    case "G" => Grass
    case "V" => Violets
    case _ => throw new Exception(s"Invalid input: $c")
  }
}

class Garden(private val child: List[String], private val cups: String) {
  val map: Map[String, List[Plant]] = Map()
  val Array(xs, ys) = cups.split("\n").map(_.grouped(2).toList)

  println(xs.mkString(","))
  println(ys.mkString(","))

  def getPlants(child: String): List[Plant] = {
    List(Plant.Violets)
  }

}

object Garden {
  def apply(childs: List[String], cups: String): Garden =
    new Garden(childs.sorted, cups)

  def defaultGarden(cups: String) =
    new Garden(
      List("Alice", "Bob", "Charlie", "David",
        "Eve", "Fred", "Ginny", "Harriet",
        "Ileana", "Joseph", "Kincaid", "Larry"), cups)
}

/*
val cups = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"
val Array(xs, ys) = cups.split("\n").map(_.grouped(2).toList)

xs.length
ys.length

xs.mkString(",")
ys.mkString(",")

List(xs, ys).transpose.flatten.mkString.grouped(4).mkString(",")

List(List(1, 2), List(1, 2)).transpose
 */