
case class Bst(value: Int, var left: Option[Bst], var right: Option[Bst]) {
  def insert(input: Int): Bst = {
    def loop(cursor: Bst, input: Int, root: Bst): Bst = {
      if (cursor.value > input) if (cursor.left.isEmpty)


      cursor match {
        case cur if cur.value > input => if (cur.left.isEmpty) cur.copy(left = Some(Bst(input))) else Bst(0)
        case cur if cur.value < input =>
      }


      root
    }

    loop(this, input, this)
  }
}

object Bst {
  def apply(value: Int): Bst = {
    new Bst(value, None, None)
  }

  def toList(bst: Bst): List[Int] = ???

  def fromList(values: List[Int]): Bst = ???
}


