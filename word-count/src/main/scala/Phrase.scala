
case class Phrase(text: String) {
  def wordCount: Map[String, Int] = {
    val xs = text.split(' ').map(_.toLowerCase).groupBy(identity)
    val ys = xs.map { case (k, vs) => (k, vs.length) }
    ys
  }
}

/*
case class Phrase(text: String) {
  def wordCount: Map[String, Int] = {
    val filtered = text.filterNot(c => ":!!&@$%^&".contains(c))
    println(filtered)
    val xs = filtered.split(' ').map(_.toLowerCase).groupBy(identity)
    val ys = xs.map { case (k, vs) => (k, vs.length) }
    ys
  }
}


val input = "car : carpet as java : javascript!!&@$%^&"

val result = input.foldLeft(("", false)) { (acc, c) =>
  val (output, skipped) = acc

  ":!!&@$%^&".contains(c) || c == ' ' && skipped


  c match {
    case c if ":!!&@$%^&".contains(c) => (output, true)
    case c if c == ' ' && skipped => (output, true)
    case _ => (output + c, false)
  }
}

result._1
 */
