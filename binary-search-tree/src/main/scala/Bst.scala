
case class Bst(value: Int, val left: Option[Bst], val right: Option[Bst]) {
  def insert(input: Int): Bst = {
    def loop(cursor: Option[Bst], in: Int): Bst = {
      cursor match {
        case None => Bst(in)
        case Some(x) =>
          if (x.value >= in) Bst(x.value, Some(loop(x.left, in)), x.right)
          else Bst(x.value, x.left, Some(loop(x.left, in)))
      }
    }

    loop(Some(this), input)
  }
}

object Bst {
  def apply(value: Int): Bst = {
    new Bst(value, None, None)
  }

  def toList(bst: Bst): List[Int] = ???

  def fromList(values: List[Int]): Bst = ???
}


