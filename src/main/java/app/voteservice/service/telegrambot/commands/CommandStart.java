package app.voteservice.service.telegrambot.commands;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class CommandStart extends CommandsImpl {
    private static final Logger log = getLogger(CommandStatus.class);

    @Override
    protected Logger getLog() {
        return log;
    }

    @Override
    protected StringBuilder replyMessageMake() {
        return new StringBuilder()
                .append("/status - Статус сервера")
                .append("\n")
                .append("/vote - Проголосовать. Ожидайте 10 секунд")
                .append("\n")
                .append("/result - Результат голосования. Принимает аргумент id участника.")
                .append("\n")
                .append("/members - Список участников")
                .append("\n")
                .append("/nominations - Список номинаций");
    }
}
