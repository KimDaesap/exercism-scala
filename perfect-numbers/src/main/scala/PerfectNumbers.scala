object NumberType extends Enumeration {
  type NumberType = Value
  val Deficient, Perfect, Abundant = values
}

object PerfectNumbers {
  def classify(number: Int): NumberType.ValueSet = {
    val factorSum = Iterator.from(1).takeWhile(_ < number).filter(number % _ == 0).sum
    factorSum match {
      case fs if fs == number => NumberType.Perfect
      case fs if fs > number => NumberType.Abundant
      case fs if fs < number => NumberType.Deficient
    }
  }
}
