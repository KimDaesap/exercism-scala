sealed trait Color
case object Black extends Color
case object Red extends Color

case object Empty extends Tree { def color = Black }
case class Node(color: Color, left: Tree, value: Int, right: Tree) extends Tree
case object Leaf extends Tree { def color = Black }

sealed trait Tree {
  def color: Color

  def isEmpty: Boolean = this == Empty

  def contains(x: Int): Boolean = this match {
    case Node(c, l, v, r) =>
      if (x < v) l.contains(x)
      else if (v < x) r.contains(x)
      else true
    case _ => false
  }

  def list: List[Int] = this match {
    case Node(c, l, v, r) => l.list ::: v :: r.list
    case _ => Nil
  }

  def traverse2[A,B](sub: Tree)(f: Tree => Tree): Tree = ???

  def equals(sub: Tree): Boolean = {
    (this, sub) match {
      case (t: Node, s: Node) =>
        if (s.value < t.value) t.left.equals(s.value)
        else if (t.value < s.value) t.right.equals(s.value)
        else t.left.equals(s.left) || t.right.equals(s.right)
      case (t, s) => t == s
    }
  }

  def isSubset(sub: Tree): Boolean = this.list.containsSlice(sub.list)

  def isDisjoint(sub: Tree): Boolean = this.list.forall(!sub.list.contains(_))

  def insert(x: Int): Tree = add(this, x) match {
    case t: Node => t.copy(color = Black)
    case _ => Empty
  }

  private def add(t: Tree, x: Int): Tree = t match {
    // BST insertion logic base + RB balance
    case Node(c, l, v, r) =>
      if (x < v) balance(Node(c, add(l, x), v, r))
      else if (v < x) balance(Node(c, l, v, add(r, x)))
      else Node(c, l, v, r)
    case Leaf => Node(Red, Leaf, x, Leaf)
    // first insert (case 1)
    case Empty => Node(Black, Leaf, x, Leaf)
  }

  private def balance(tree: Tree): Tree = tree match {
    case Node(Black, Node(Red, Node(Red, a, x, b), y, c), z, d) =>
      Node(Red, Node(Black, a, x, b), y, Node(Black, c, z, d))
    case Node(Black, Node(Red, a, x, Node(Red, b, y, c)), z, d) =>
      Node(Red, Node(Black, a, x, b), y, Node(Black, c, z, d))
    case Node(Black, a, x, Node(Red, b, y, Node(Red, c, z, d))) =>
      Node(Red, Node(Black, a, x, b), y, Node(Black, c, z, d))
    case Node(Black, a, x, Node(Red, Node(Red, b, y, c), z, d)) =>
      Node(Red, Node(Black, a, x, b), y, Node(Black, c, z, d))
    case _ => tree
  }
}

object Tree {
  def apply(): Tree = Empty

  def fromList(list: List[Int]): Tree = {
    list.foldLeft(Tree()) ((acc, x) => acc.insert(x))
  }
}
