object Queens {
  def boardString(white: Option[Position], black: Option[Position]): String = {
    val board = Array.fill(8, 8)('_')
    white.foreach(p => board(p.x)(p.y) = 'W')
    black.foreach(p => board(p.x)(p.y) = 'B')
    board.map(cs => cs.mkString(" ") + '\n').mkString
  }

  def canAttack(white: Position, black: Position): Boolean = {
    (white.x == black.x) || (white.y == black.y) ||
      (Math.abs(white.x - black.x) == Math.abs(white.y - black.y))
  }
}

case class Position(x: Int, y: Int)
