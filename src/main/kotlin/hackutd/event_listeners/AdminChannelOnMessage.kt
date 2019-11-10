package hackutd.event_listeners

import com.google.common.eventbus.Subscribe
import hackutd.CHANNEL_NAME
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent


class AdminChannelOnMessage {

    @Subscribe
    fun onMessage(event: GuildMessageReceivedEvent) {

        // Everything in the #task-admin channel is interpreted as a command,
        // no prefix needed.

        val channel = event.channel

        if (event.author.isBot) // Avoid infinite loop
            return

        if (channel.name == CHANNEL_NAME) {  // If in the task-admin channel
            val msg = event.message.contentRaw.trim()

            when (msg.toLowerCase()) {
                // TODO actual implementation
                "assign" -> event.message.channel.sendMessage("Assign!").queue()
                "setuser" -> event.message.channel.sendMessage("Set user!").queue()
                "deluser" -> event.message.channel.sendMessage("Delete user!").queue()
                "setreminders" -> event.message.channel.sendMessage("Set reminders!").queue()
                else -> event.message.channel.sendMessage("Unrecognized command.").queue()
            }
        }
    }
}