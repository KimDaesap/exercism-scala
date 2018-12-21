import java.time.{LocalDate, LocalDateTime, LocalTime}

object Gigasecond {
  val Secs = 1000000000

  def add(startDate: LocalDate): LocalDateTime =
    LocalDateTime.of(startDate, LocalTime.MIN).plusSeconds(Secs)

  def add(startDateTime: LocalDateTime): LocalDateTime =
    startDateTime.plusSeconds(Secs)
}
