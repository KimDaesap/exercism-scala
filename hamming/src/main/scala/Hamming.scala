
object Hamming {

  def compute(left: String, right: String): Option[Int] = {
    def loop(x: Seq[Char], y: Seq[Char], acc: Int): Option[Int] = {
      (x, y) match {
        case (Seq(), Seq()) => Some(acc)
        case (lh +: lt, rh +: rt) =>
          loop(lt, rt, if (lh == rh) acc else acc + 1)
        case _ => None
      }
    }

    loop(left, right, 0)
  }

}
