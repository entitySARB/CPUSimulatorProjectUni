import java.io.File
import java.util.Scanner

object Storage {
    val instructions = mutableListOf<String>()
    init {
        print("Instructions file: ")
        val sc = Scanner(File(readln()))
        while (sc.hasNextLine()) {
            instructions.add(sc.nextLine().dropLast(1))
        }
        sc.close()
    }
}