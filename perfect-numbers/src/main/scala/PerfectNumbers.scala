object NumberType extends Enumeration {
  val Deficient = Value(-1)
  val Perfect = Value(0)
  val Abundant = Value(1)
}

object PerfectNumbers {
  def classify(number: Int) = {
    val factorSum = (1 to number / 2).filter(number % _ == 0).sum
    NumberType(factorSum compare number)
  }
}
