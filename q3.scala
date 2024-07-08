object StringFormatter {

  def toUpper(input: String): String = {
    input.toUpperCase
  }

  def toLower(input: String): String = {
    input.toLowerCase
  }

  def formatNames(name: String)(formatFunction: String => String): String = {
    formatFunction(name)
  }

  def main(args: Array[String]): Unit = {
    val names = List("Benny", "Niroshan", "Saman", "Kumara")
    

    val formattedNames = names.zipWithIndex.map {
      case (name, index) => 
        index match {
          case 0 => formatNames(name)(toUpper)
          case 1 => formatNames(name)(n => n.substring(0, 2).toUpperCase + n.substring(2).toLowerCase)
          case 2 => formatNames(name)(toLower)
          case 3 => formatNames(name)(n => n.substring(0, n.length - 1).toLowerCase + n.last.toUpper)
        }
    }
    
    formattedNames.foreach(println)
  }
}
