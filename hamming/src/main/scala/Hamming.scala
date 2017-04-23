
object Hamming {

  def compute(left: String, right: String): Option[Int] = {
    def loop(x: List[Char], y: List[Char], acc: Int): Option[Int] = {
      (x, y) match {
        case (Nil, Nil) => Some(acc)
        case (lh :: lt, rh :: rt) =>
          loop(lt, rt, if (lh == rh) acc else acc + 1)
        case _ => None
      }
    }

    loop(left.toList, right.toList, 0)
  }

}
