object NumberType extends Enumeration {
  val Deficient = Value(-1)
  val Perfect = Value(0)
  val Abundant = Value(1)
}

object PerfectNumbers {
  def classify(number: Int) = {
    NumberType({
      val factorSum = (1 to number / 2).filter(number % _ == 0).sum
      factorSum compare number
    })
  }
}
