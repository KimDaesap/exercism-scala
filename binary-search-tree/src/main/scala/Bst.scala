
case class Bst(value: Int, val left: Option[Bst], val right: Option[Bst]) {
  def insert(input: Int): Bst = {
    def loop(cursor: Option[Bst]): Bst = cursor match {
        case None => Bst(input)
        case Some(x) =>
          if (x.value >= input) Bst(x.value, Some(loop(x.left)), x.right)
          else Bst(x.value, x.left, Some(loop(x.right)))
    }

    loop(Some(this))
  }
}

object Bst {
  def apply(value: Int): Bst = new Bst(value, None, None)

  def fromList(values: List[Int]): Bst =
    values.tail.foldLeft(Bst(values.head)) { (acc, v) => acc.insert(v) }

  def toList(bst: Bst): List[Int] = {
    def loop(cursor: Option[Bst]): List[Int] = cursor.get match {
      case Bst(x, _, Some(r)) => x :: loop(Some(r))
      case _ => Nil
//      case Bst(x, Some(l), _) => Nil
    }

    loop(Some(bst))
  }
}