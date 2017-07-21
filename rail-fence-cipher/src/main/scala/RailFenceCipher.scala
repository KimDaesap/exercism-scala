import scala.collection.mutable.ListBuffer

object RailFenceCipher {
  def encode(text: String, railNumber: Int): String = {
    def go(ts: String, number: Int, increment: Int, rails: ListBuffer[String]): ListBuffer[String] = {
      if (ts.isEmpty) rails
      else {
        val inc = if (number == 0) 1
        else if (number >= (railNumber - 1)) -1
        else increment
        rails(number) = rails(number) + ts.head
        go(ts.tail, number + inc, inc, rails)
      }
    }

    go(text, 0, 1, ListBuffer.fill(railNumber)("")).mkString
  }

  def decode(text: String, depth: Int): String = {

    ???
  }
}