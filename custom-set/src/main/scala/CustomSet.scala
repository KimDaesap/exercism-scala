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

  def stream: Stream[Int] = this match {
    case Node(c, l, v, r) => l.stream #::: v #:: r.stream
    case _ => Stream.Empty
  }

  def isEqual(sub: Tree): Boolean = this.stream == sub.stream

  def isSubset(sub: Tree): Boolean = this.stream.containsSlice(sub.stream)

  def isDisjointFrom(sub: Tree): Boolean = this.stream.forall(!sub.stream.contains(_))

  def intersection(sub: Tree): Tree = Tree.fromSeq(this.stream.filter(sub.stream.contains(_)))

  def difference(sub: Tree): Tree = Tree.fromSeq(this.stream.filter(!sub.stream.contains(_)))

  def union(sub: Tree): Tree = sub.stream.foldLeft(this) ((acc, x) => acc.insert(x))

  def insert(x: Int): Tree = {
    def add(t: Tree, x: Int): Tree = t match {
      // BST insertion logic base + RB balance
      case Node(c, l, v, r) =>
        if (x < v) balance(Node(c, add(l, x), v, r))
        else if (v < x) balance(Node(c, l, v, add(r, x)))
        else Node(c, l, v, r)
      case Leaf => Node(Red, Leaf, x, Leaf)
      // first insert (case 1)
      case Empty => Node(Black, Leaf, x, Leaf)
    }

    def balance(tree: Tree): Tree = tree match {
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

    add(this, x) match {
      case t: Node => t.copy(color = Black)
      case _ => Empty
    }
  }
}

object Tree {
  def apply(): Tree = Empty
  def fromSeq(xs: Seq[Int]): Tree = xs.foldLeft(Tree()) ((acc, x) => acc.insert(x))
}

case class CustomSet(tree: Tree)

object CustomSet {
  def apply(): CustomSet = CustomSet(Tree())

  def fromList(list: List[Int]): CustomSet = CustomSet(Tree.fromSeq(list))

  def member(set: CustomSet, n: Int): Boolean = set.tree.contains(n)

  def empty(set: CustomSet): Boolean = set.tree.isEmpty

  def isEqual(left: CustomSet, right: CustomSet): Boolean =
    left.tree.isEqual(right.tree)

  def isSubsetOf(left: CustomSet, right: CustomSet): Boolean =
    right.tree.isSubset(left.tree)

  def isDisjointFrom(left: CustomSet, right: CustomSet): Boolean =
    left.tree.isDisjointFrom(right.tree)

  def insert(set: CustomSet, n: Int): CustomSet = CustomSet(set.tree.insert(n))

  def intersection(left: CustomSet, right: CustomSet): CustomSet =
    CustomSet(left.tree.intersection(right.tree))

  def difference(left: CustomSet, right: CustomSet): CustomSet =
    CustomSet(left.tree.difference(right.tree))

  def union(left: CustomSet, right: CustomSet): CustomSet =
    CustomSet(right.tree.union(left.tree))
}