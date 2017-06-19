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

class CustomSet(val tree: Tree) {
  def this(list: List[Int]) { this(Tree.fromList(list.sorted)) }
  def list: List[Int] = tree.list
}

object CustomSet {
  def apply(): CustomSet = new CustomSet(Nil)

  def fromList(list: List[Int]): CustomSet = new CustomSet(list)

  def member(set: CustomSet, n: Int): Boolean = set.tree.contains(n)

  def empty(set: CustomSet): Boolean = set.tree.isEmpty

  def isEqual(left: CustomSet, right: CustomSet): Boolean =
    left.list == right.list

  def isSubsetOf(left: CustomSet, right: CustomSet): Boolean =
    right.list.containsSlice(left.list)

  def isDisjointFrom(left: CustomSet, right: CustomSet): Boolean =
    left.list.forall(!right.tree.contains(_))

  def insert(set: CustomSet, n: Int): CustomSet = new CustomSet(set.tree.insert(n))

  def intersection(left: CustomSet, right: CustomSet): CustomSet =
    fromList(left.list.filter(right.tree.contains(_)))

  def difference(left: CustomSet, right: CustomSet): CustomSet =
    fromList(left.list.filter(!right.tree.contains(_)))

  def union(left: CustomSet, right: CustomSet): CustomSet = right.list match {
    case Nil => left
    case h :: t => union(insert(left, h), fromList(t))
  }
}