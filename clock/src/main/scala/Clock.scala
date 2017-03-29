class Clock private (val h: Int, val m: Int) {
  def +(other: Clock): Clock = Clock(h + other.h, m + other.m)
  def -(other: Clock): Clock = Clock(h - other.h, m - other.m)
  override def equals(other: Any): Boolean = other match {
    case o: Clock => (h == o.h && m == o.m)
    case _ => false
  }
  override def toString(): String = "%02d:%02d".format(h,m)
}

object Clock {
  val DayHours = 24
  val HourMinutes = 60

  def apply(m: Int): Clock = apply(0, m)
  def apply(h: Int, m: Int): Clock = {
    val nm = (HourMinutes + (m % HourMinutes)) % HourMinutes
    val mh = Math.floor(m.toDouble / HourMinutes.toDouble).toInt
    val nh = (DayHours + (h % DayHours) + (mh % DayHours)) % DayHours
    new Clock(nh, nm)
  }
}
