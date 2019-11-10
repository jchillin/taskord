package hackutd.commands

import hackutd.setTaskMessage
import me.aberrantfox.kjdautils.api.dsl.CommandSet
import me.aberrantfox.kjdautils.api.dsl.commands

var count = 0

@CommandSet("Task")
fun taskCommands() = commands {
    command("Ping") {
        description = "Responds with pong!"
        execute {
            it.respond("pong!")
        }

    }

    command("Increment") {
        execute {
            setTaskMessage("Count: ${count}",it.guild!!)
            count++
        }
    }
}
