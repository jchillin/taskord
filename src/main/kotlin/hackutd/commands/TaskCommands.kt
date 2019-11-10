package hackutd.commands

import me.aberrantfox.kjdautils.api.dsl.CommandSet
import me.aberrantfox.kjdautils.api.dsl.commands

@CommandSet("Task")
fun taskCommands() = commands {
    command("Ping") {
        description = "Responds with pong!"
        execute {
            it.respond("pong!")
        }
    }
}
