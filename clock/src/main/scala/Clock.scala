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
    val totalMin = Math.floorMod(h * HourMinutes + m, DayMinutes)
    val hour: Int = totalMin / HourMinutes
    val minute: Int = totalMin % HourMinutes
    new Clock(hour, minute)
  }
}
