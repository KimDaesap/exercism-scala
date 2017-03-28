object Luhn {
  def validate(digits: String): Boolean = {
    val normal = digits.replace(" ", "").reverse
    if (normal.forall(_.isDigit)) {
      val sum = normal.map(_.asDigit).zipWithIndex.foldLeft(0) {
        (acc, tup) => tup match {
          case (value, index) if (index % 2 == 1) =>
            val double = value * 2
            val salt = if (double > 10) -9 else 0
            acc + double + salt
          case (v, _) => acc + v
        }
      }
      (sum != 0) && (sum % 10 == 0)
    }
    else false
  }
}