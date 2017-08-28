object Dominoes {
  type Value = (Int, Int)
  type ValueList = List[Value]

  def chain(dominoes: List[(Int, Int)]): Option[List[(Int, Int)]] = {
    permutations(dominoes.head._1, dominoes.head._2, dominoes)
  }

  private def permutations(list: ValueList): Option[ValueList] = {
    def loop(first: Int, last: Int, length: Int, ls: ValueList): List[ValueList] = {
      if (length == 0) ls.map(List(_))
      else {
        for {
          i <- ls
          (l, r) = i
          j <- loop(length - 1, ls.diff(List(i)))
        } yield i :: j
      }
    }

    loop(list.length - 1, list)
  }
}
