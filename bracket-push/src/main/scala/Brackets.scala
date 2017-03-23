object Brackets {
  val brackets = Map('[' -> ']', '{' -> '}', '(' ->')')

  def areBalanced(input: String): Boolean = {
    def loop(xs: List[Char], acc: List[Char]): Boolean = xs match {
      case Nil => acc.isEmpty
      case h :: t if brackets.keys.toList.contains(h) => loop(t, h :: acc)
      case h :: t if brackets.values.toList.contains(h) =>
        if (acc.nonEmpty && h == brackets(acc.head)) loop(t, acc.tail)
        else false
      case h :: t => loop(t, acc)
    }
    loop(input.toList, Nil)
  }
}
