package hackutd

import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.TextChannel

var taskChannel: TextChannel? = null
var taskMessageId: Long? = null


val CHANNEL_NAME = "task_admin"

fun setTaskMessage(msg: String, guild: Guild) {

    val channelMatches = guild.getTextChannelsByName(CHANNEL_NAME, true)
    if (channelMatches.size == 0) {
        // If the channel does not exist, create it and create the message
        guild.createTextChannel(CHANNEL_NAME).queue { channel ->
            taskChannel = channel // Update the stored channel
            channel.sendMessage(msg)
                .queue { message -> taskMessageId = message.idLong }
        }
    }
    else // Channel exists
    {
        // TODO: Handle excessive matches (delete)

        // If the channel exists and the message exists, just edit the message
        // However if the message exists, the channel is invalid (e.g. may
        // have a version of the message from an earlier run), so we clear the
        // channel history by cloning and removing the channel

        val channel = channelMatches[0]

        // If we have a message, check whether it still exists
        // If it exists, we just edit it.
        // If it doesn't exist, or we don't have a message (in which case we use
        // a random message id), we recreate the channel and then create the message
        channel.retrieveMessageById(taskMessageId ?: -1)
            .queue(
                { message -> message.editMessage(msg).queue() },
                { _fail ->
                    // Clone channel and delete old one to clear out
                    guild.createCopyOfChannel(channel).queue { clone ->

                        // on clone, delete old one
                        channel.delete().queue()

                        // Add message and save id
                        clone.sendMessage(msg)
                            .queue { message -> taskMessageId = message.idLong }
                    }
                }
            )
    }
}




