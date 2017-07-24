import scala.collection.mutable.ListBuffer

object RailFenceCipher {
  def encode(text: String, railNumber: Int): String = {
    type Rails = ListBuffer[String]

    def go(ts: String, number: Int, inc: Int, rails: Rails): Rails = {
      if (ts.isEmpty) rails
      else {
        val ninc =
          if (number == 0) 1
          else if (number == (railNumber - 1)) -1
          else inc
        rails(number) += ts.head
        go(ts.tail, number + ninc, ninc, rails)
      }
    }

    go(text, 0, 1, ListBuffer.fill(railNumber)("")).mkString
  }

  def decode(text: String, railNumber: Int): String = {
    type Rails = ListBuffer[ListBuffer[Int]]

    def go1(ts: String, number: Int, inc: Int, index: Int, rails: Rails): List[Int] = {
      if (ts.isEmpty) rails.foldLeft(List[Int]())((acc, xs) => acc ::: xs.toList)
      else {
        val ninc =
          if (number == 0) 1
          else if (number == (railNumber - 1)) -1
          else inc
        rails(number) += index
        go1(ts.tail, number + ninc, ninc, index + 1, rails)
      }
    }

    val indexes = go1(text, 0, 1, 0, ListBuffer.fill(railNumber)(ListBuffer[Int]()))
    (0 until text.length).foldLeft("")((acc, i) => {
      acc + text(indexes.indexOf(i))
    })
  }
}