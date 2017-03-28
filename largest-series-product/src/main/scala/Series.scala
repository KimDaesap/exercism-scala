object Series {
  def largestProduct(n: Int, digits: String): Option[Int] = {
    if (n == 0) Some(1)
    else if (digits.length < n) None
    else Some(digits.map(_.asDigit).sliding(n).map(_.product).max)
  }

}
