package app.voteservice.service.telegrambot.commands;

import java.util.HashMap;
import java.util.Map;

import static app.voteservice.service.telegrambot.commands.CommandsEnum.*;
import static app.voteservice.utils.Utils.substringBeforeSpace;

public class CommandsFactory {
    private static final Map<String, Commands> commandFactory = new HashMap<>();

    static {
        commandFactory.put(COMMAND_START.getValue(), new CommandStart());
        commandFactory.put(COMMAND_STATUS.getValue(), new CommandStatus());
        /*commandFactory.put(COMMAND_MEMBERS.getValue(), new CommandMembers());
        commandFactory.put(COMMAND_RESULT.getValue(), new CommandResult());
        commandFactory.put(COMMAND_VOTE.getValue(), new CommandVote());
        commandFactory.put(COMMAND_NOMINATIONS.getValue(), new CommandNominations());*/
        commandFactory.put(COMMAND_DEFAULT.getValue(), new CommandDefault());
    }

    public static Commands getInstance(String data) {
        return commandFactory.get(getCommand(data));
    }

    private static String getCommand(String data) {
        return substringBeforeSpace(data);
    }
}
