class CustomSet(var list: List[Int]) { list = list.sorted }

object CustomSet {
  def apply(): CustomSet = new CustomSet(List())

  def fromList(list: List[Int]): CustomSet = new CustomSet(list)

  def empty(set: CustomSet): Boolean = set.list.isEmpty

  def isEqual(left: CustomSet, right: CustomSet): Boolean =
    left.list.equals(right.list)

  def isSubsetOf(left: CustomSet, right: CustomSet): Boolean =
    right.list.containsSlice(left.list)

  def isDisjointFrom(left: CustomSet, right: CustomSet): Boolean =
    left.list.forall(!right.list.contains(_))

  def member(set: CustomSet, n: Int): Boolean =
    set.list.contains(n)

  def insert(set: CustomSet, n: Int): CustomSet =
    fromList(if (!set.list.contains(n)) n :: set.list else set.list)

  def intersection(left: CustomSet, right: CustomSet): CustomSet =
    fromList(left.list.filter(right.list.contains(_)))

  def difference(left: CustomSet, right: CustomSet): CustomSet =
    fromList(left.list.filter(!right.list.contains(_)))

  def union(left: CustomSet, right: CustomSet): CustomSet = right.list match {
    case Nil => left
    case h :: t => union(insert(left, h), fromList(t))
  }

}
