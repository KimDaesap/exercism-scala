sealed trait Bowling {
  def roll(pins: Int): Bowling = {
    val game = this match {
      case _ if !(0 <= pins && pins <= 10) => ErrorGame(Error("Illegal pins"))

      case FinishedGame(_) => ErrorGame(Error("aready finished game"))

      case PlayingGame(f, Nil, acc) => PlayingGame(f, List(pins), acc)

      case PlayingGame(f, p1 :: Nil, acc) =>
        // strike or spear
        if (p1 == 10 || p1 + pins == 10) PlayingGame(f, List(p1, pins), acc)
        // open
        else if (p1 + pins > 10) ErrorGame(Error("frame score more than 10"))
        else PlayingGame(f + 1, Nil, acc + p1 + pins)

//      case PlayingGame(10, p1 :: p2 :: Nil, acc) =>
//        // strike!
//        if (p1 == 10) {
//          if (p2 == 10 || p2 + pins <= 10) FinishedGame(acc + p1 + p2 + pins)
//          else ErrorGame(Error("rolls bonus more than 10"))
//        }
//        else FinishedGame(acc + p1 + p2 + pins)

      case PlayingGame(f, p1 :: p2 :: Nil, acc) =>
        // strike!
        if (p1 == 10) PlayingGame(f + 1, List(p2, pins), acc + p1 + p2 + pins)
        // spear!
        else PlayingGame(f + 1, List(pins), acc + p1 + p2 + pins)

      case _ => this
    }

    println(game)

    game match {
      case PlayingGame(f, ps, acc) if f == 11 => FinishedGame(acc)
      case _ => game
    }
  }

  def score(): Either[Error, Int] = this match {
    case FinishedGame(score) => Right(score)
    case PlayingGame(_,_,_) => Left(Error("Not finished game"))
    case ErrorGame(err) => Left(err)
  }
}

case class PlayingGame(frame: Int, pins: List[Int], previousScore: Int) extends Bowling
case class FinishedGame(totalScore: Int) extends Bowling
case class ErrorGame(err: Error) extends Bowling

case class Error(errorText: String)

object Bowling {
  def apply(): Bowling = PlayingGame(1, List(), 0)
}

