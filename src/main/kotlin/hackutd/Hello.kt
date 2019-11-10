package hackutd

import me.aberrantfox.kjdautils.api.dsl.PrefixDeleteMode
import me.aberrantfox.kjdautils.api.startBot


fun main(args: Array<String>) {
    startBot("your-bot-token-goes-here") {
        configure {
            prefix = "!"
            globalPath = "hackutd"
            reactToCommands = true
            deleteMode = PrefixDeleteMode.None
        }
    }
}

