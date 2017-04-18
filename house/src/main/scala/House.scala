object House {
  case class Sentence(left: String, right: String)

  val inputs = List(
    Sentence("lay in", "the house that Jack built.\n"),
    Sentence("ate", "the malt"),
    Sentence("killed", "the rat"),
    Sentence("worried", "the cat"),
    Sentence("tossed", "the dog"),
    Sentence("milked", "the cow with the crumpled horn"),
    Sentence("kissed", "the maiden all forlorn"),
    Sentence("married", "the man all tattered and torn"),
    Sentence("woke", "the priest all shaven and shorn"),
    Sentence("kept", "the rooster that crowed in the morn"),
    Sentence("belonged to", "the farmer sowing his corn"),
    Sentence("is", "the horse and the hound and the horn")
  )

  def paragraph(xs: List[Sentence], isFirst: Boolean): List[String] = {
    xs match {
      case Nil => Nil
      case h :: t =>
        if (isFirst) s"This is ${h.right}" :: paragraph(t, false)
        else s"that ${h.left} ${h.right}" :: paragraph(t, false)
    }
  }

  def loop(xs: List[Sentence], stack: List[Sentence], acc: List[String]): List[String] = {
    xs match {
      case Nil => acc
      case h :: t => {
        val ys = h :: stack
        loop(t, ys, acc ::: paragraph(ys, true))
      }
    }
  }

  def rhyme(): String = {
    val r = loop(inputs, Nil, Nil)
    r.mkString("\n") + "\n"
  }
}
