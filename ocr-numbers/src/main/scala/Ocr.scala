case class Ocr(text: String) {
  val digits = Map(
    " _ | ||_|   " -> "0",
    "     |  |   " -> "1",
    " _  _||_    " -> "2",
    " _  _| _|   " -> "3",
    "   |_|  |   " -> "4",
    " _ |_  _|   " -> "5",
    " _ |_ |_|   " -> "6",
    " _   |  |   " -> "7",
    " _ |_||_|   " -> "8",
    " _ |_| _|   " -> "9"
  )

  def convert: String = {

    def line(t: String): (List[String], String) = {
      if (t.startsWith("\n")) (Nil, t.tail)
      else if(t.isEmpty) (Nil, t)
      else {
        val (l, r) = t.splitAt(3)
        val (ls, r2) = line(r)
        (l :: ls, r2)
      }
    }

    def line4(n: Int, t: String, acc: List[String]): (List[String], String) = {
      if (n > 0) {
        val (ls, r) = line(t)
        line4(n - 1, r,
          acc.zipAll(ls, "", "").map { case (a,b) => a + b }
        )
      }
      else (acc, t)
    }

    def chunk(t: String, acc: String): String = {
      if (t.isEmpty) acc
      else {
        val (ls, r) = line4(4, t, Nil)
        acc + (if (acc.isEmpty) "" else ",") +
          chunk(r, ls.map(a => digits.getOrElse(a, "?")).mkString)
      }
    }

    chunk(text, "")
  }
}