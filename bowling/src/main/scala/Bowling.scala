sealed trait Bowling {
  def roll(pins: Int): Bowling
  def score(): Either[Error, Int]
}

object Bowling {
  def apply(): Bowling = new Bowl

  class Bowl extends Bowling {

    override def roll(pins: Int): Bowling = {

      ???
    }

    override def score(): Either[Error, Int] = {

      ???
    }
  }
}

case class Error(errorText: String)