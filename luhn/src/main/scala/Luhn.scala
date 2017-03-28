object Luhn {
  def validate(digits: String): Boolean = {

    false
  }

}


/*
val input = "046 454 286"
val digits = input.replaceAll(" ", "").reverse.map(_.asDigit)



input.replace(" ", "").forall(c => c.isDigit)



Option("046 454 286".filter(_.isDigit))


Option(null)
Option(Nil)

digits
digits(0)


val grouped = digits.grouped(2)
val evens = Iterator.from(0, 2).takeWhile(_ < digits.length).map(digits(_))
val odds = Iterator.from(1, 2).takeWhile(_ < digits.length).map(digits(_))

digits
grouped.foreach(println)

grouped.mkString



evens.foreach(println)
odds.foreach(println)


//Option(throw new Exception("I am a boy"))
 */