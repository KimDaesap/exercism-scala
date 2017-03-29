class Clock private (val h: Int, val m: Int) {
  def +(other: Clock) = Clock(h + other.h, m + other.m)
  def -(other: Clock) = Clock(h - other.h, m - other.m)
  override def equals(other: Any) = other match {
    case o: Clock => (h == o.h && m == o.m)
    case _ => false
  }
  override def toString(): String = "%02d:%02d".format(h,m)
}

object Clock {
  val DayHours = 24
  val HourMinutes = 60
  val DayMinutes = DayHours * HourMinutes

  def apply(m: Int): Clock = apply(0, m)
  def apply(h: Int, m: Int) = {
    val totalMinutes = Math.floorMod(h * 60 + m, DayMinutes)
    val hour: Int = totalMinutes / 60
    val minute: Int = totalMinutes % 60
    new Clock(hour, minute)
  }
}
