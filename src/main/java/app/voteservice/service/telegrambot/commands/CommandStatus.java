package app.voteservice.service.telegrambot.commands;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class CommandStatus extends CommandsImpl {
    private static final Logger log = getLogger(CommandStatus.class);
    private final String STATUS_OK = "OK";

    @Override
    protected Logger getLog() {
        return log;
    }

    @Override
    protected StringBuilder replyMessageMake() {
        return new StringBuilder().append(STATUS_OK);
    }
}
