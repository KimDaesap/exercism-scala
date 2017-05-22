object PascalsTriangle {
  def triangle(level: Int): List[List[Int]] = {
    def loop(curLv: Int, toLv: Int, prev: List[Int]): List[List[Int]] = {
      if (curLv > toLv) Nil
      else {
        val mid = if (prev.length == 1) Nil
        else prev.sliding(2, 1).map(_.sum).toList

        prev :: loop(curLv + 1, toLv, 1 :: mid ::: List(1))
      }
    }
    loop(1, level, List(1))
  }
}
