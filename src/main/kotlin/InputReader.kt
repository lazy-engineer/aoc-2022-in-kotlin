import java.io.File

object InputReader {
    fun readFileLineByLineUsingForEachLine(fileName: String) = File(fileName).forEachLine { println(it) }
    fun readFileAsLinesUsingUseLines(fileName: String): List<String> = File(fileName).useLines { it.toList() }
    fun File.useLinesFromFile(): List<String> = this.useLines { it.toList() }
    fun readFileAsText(fileName: String): String = File(fileName).readText()
}