class CustomSet(val tree: Tree) {
  def this(list: List[Int]) { this(Tree.fromList(list.sorted)) }
}

object CustomSet {
  def apply(): CustomSet = new CustomSet(Nil)

  def fromList(list: List[Int]): CustomSet = new CustomSet(list)

  def member(set: CustomSet, n: Int): Boolean = set.tree.contains(n)

  def empty(set: CustomSet): Boolean = set.tree.isEmpty

  def isEqual(left: CustomSet, right: CustomSet): Boolean =
    left.tree.Equals(right.tree)

  def isSubsetOf(left: CustomSet, right: CustomSet): Boolean =
    right.tree.isSubset(left.tree)

  def isDisjointFrom(left: CustomSet, right: CustomSet): Boolean =
    left.tree.isDisjoint(right.tree)

  def insert(set: CustomSet, n: Int): CustomSet = new CustomSet(set.tree.insert(n))

  def intersection(left: CustomSet, right: CustomSet): CustomSet = ???

  def difference(left: CustomSet, right: CustomSet): CustomSet = ???

  def union(left: CustomSet, right: CustomSet): CustomSet = ???

}
