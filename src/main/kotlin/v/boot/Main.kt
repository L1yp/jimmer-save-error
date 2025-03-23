package v.boot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.io.File

@SpringBootApplication
class Main

fun main(args: Array<String>) {
    val dir = System.getProperty("user.dir")
    val file = File("$dir/db/example.db")
    if (!file.exists()) {
        file.parentFile.mkdirs()
    }
    runApplication<Main>(*args)
}