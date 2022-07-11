package app.voteservice.service.telegrambot;

import app.voteservice.configurations.Bot;
import app.voteservice.configurations.User;
import app.voteservice.configurations.TelegramUsers;
import app.voteservice.service.telegrambot.handlers.Handler;
import app.voteservice.service.telegrambot.handlers.RouterFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    private static final Logger log = getLogger(TelegramBot.class);

    private final String botUsername;
    private final String botToken;
    private final TelegramUsers telegramUsers;

    public TelegramBot(TelegramBotsApi telegramBotsApi, Bot bot, TelegramUsers telegramUsers) throws TelegramApiException {
        this.botUsername = bot.getName();
        this.botToken = bot.getToken();
        this.telegramUsers = telegramUsers;
        for (User user : telegramUsers.getUsers()) {
            System.out.println(user.getTitle());
        }

        telegramBotsApi.registerBot(this);
    }

    public void onUpdateReceived(Update update) {
        Handler handler = RouterFactory.getInstance(update);
        SendMessage sendMessage = handler.getMessage(update);
        executeMessage(sendMessage);
    }

    private <T extends BotApiMethod<Message>> void executeMessage(T message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
