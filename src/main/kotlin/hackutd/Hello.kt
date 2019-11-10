package hackutd

import me.aberrantfox.kjdautils.api.dsl.PrefixDeleteMode
import me.aberrantfox.kjdautils.api.startBot
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Table


fun main(args: Array<String>) {
    Database.connect("jdbc:mysql://localhost:3306/test", driver = "com.mysql.jdbc.Driver",
        user = dbUser, password = dbPassword)
    startBot(botToken) {
        configure {
            prefix = "!"
            globalPath = "hackutd"
            reactToCommands = true
            deleteMode = PrefixDeleteMode.None
        }
    }
}


object Tasks : IntIdTable() {
    val name = varchar("name", length = 255)
    val desc = text("desc").nullable()
    val user = reference("user",Users)
}

object Users : IntIdTable() {
    val name = varchar("name", length=50)
    val username = varchar("username", length=50)

}