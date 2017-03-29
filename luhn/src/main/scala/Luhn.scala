object Luhn {
  def validate(digits: String): Boolean = {
    val normal = digits.replace(" ", "").reverse
    lazy val values = normal.map(_.asDigit)

    def loop(index: Int,  sum: Int): Boolean = {
      if (index == values.length) (sum != 0) && (sum % 10 == 0)
      else {
        val value = values(index)

        if (index % 2 == 1) loop(index + 1, sum + value)
        else {
          val double = value * 2
          val salt = if (double > 10) -9 else 0
          loop(index + 1, sum + double + salt)
        }
      }
    }

    if (normal.forall(_.isDigit)) loop(0, 0)
    else false
  }
}