
case class Bst(value: Int, left: Option[Bst], right: Option[Bst]) {
  def insert(input: Int): Bst = {
    def loop(cursor: Option[Bst]): Bst = cursor match {
        case None => Bst(input)
        case Some(c) =>
          if (c.value >= input) Bst(c.value, Some(loop(c.left)), c.right)
          else Bst(c.value, c.left, Some(loop(c.right)))
    }
    loop(Some(this))
  }
}

object Bst {
  def apply(value: Int): Bst = new Bst(value, None, None)

  def fromList(values: List[Int]): Bst =
    values.tail.foldLeft(Bst(values.head)) { (acc, v) => acc.insert(v) }

  def toList(bst: Bst): List[Int] = {
    def loop(cursor: Option[Bst]): List[Int] = cursor match {
      case None => Nil
      case Some(c) => loop(c.left) ::: c.value :: loop(c.right)
    }
    loop(Some(bst))
  }
}