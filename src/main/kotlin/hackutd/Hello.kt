package hackutd

import me.aberrantfox.kjdautils.api.dsl.PrefixDeleteMode
import me.aberrantfox.kjdautils.api.startBot


fun main(args: Array<String>) {
    startBot("NjQyOTA1ODMxMzEwMDk4NDM4.XcdyeA.cKgLXYq68QJKxKGTEGc_TlZx-ZY") {
        configure {
            prefix = "!"
            globalPath = "hackutd"
            reactToCommands = true
            deleteMode = PrefixDeleteMode.None
        }
    }
}

