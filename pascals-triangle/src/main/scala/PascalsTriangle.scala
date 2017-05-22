object PascalsTriangle {
  def triangle(level: Int): List[List[Int]] = {
    def loop(curLv: Int, toLv: Int, prev: List[Int]): List[List[Int]] = {
      if (curLv > toLv) Nil
      else {
        val next = (0 :: prev) zip (prev :+ 0) map { case (x, y) => x + y }
        prev :: loop(curLv + 1, toLv, next)
      }
    }
    loop(1, level, List(1))
  }
}
