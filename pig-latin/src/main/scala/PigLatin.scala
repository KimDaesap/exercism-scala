object PigLatin {
  val vowels = List('a', 'e', 'i', 'o', 'u')

  def translate(sentence: String): String = {
    def word(word: String): String = {
      def loop(s: Seq[Char], acc: String): String = s match {
        case 'q' +: 'u' +: t => t + acc + "qu"
        case h +: t =>
          if (vowels.contains(h)) h + t.toString + acc
          else loop(t, acc + h)
      }

      loop(word, "") + "ay"
    }

    sentence.split(" ").map(word(_)).mkString(" ")
  }
}
