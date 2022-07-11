package app.voteservice.service.telegrambot.handlers;

import app.voteservice.service.telegrambot.commands.Commands;
import app.voteservice.service.telegrambot.commands.CommandsFactory;
import app.voteservice.service.telegrambot.keyboards.InlineKeyboardMaker;
import org.slf4j.Logger;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.validation.constraints.NotNull;

import static app.voteservice.service.telegrambot.commands.CommandsEnum.COMMAND_START;
import static org.slf4j.LoggerFactory.getLogger;

class MessageHandler implements Handler {
    private static final Logger log = getLogger(MessageHandler.class);

    @Override
    public SendMessage getMessage(Update update) {
        Message message = update.getMessage();

        final String chatId = message.getChatId().toString();

        //if (validateUser(chatId)) {
        String data = message.getText();
        log.debug("InputData: " + "chatId=" + chatId + " data=" + data);

        Commands commands = CommandsFactory.getInstance(data);
        SendMessage sendMessage = commands.execute(chatId, data);

        if (data.equals(COMMAND_START.getValue())) {
            InlineKeyboardMaker inlineKeyboardMaker = new InlineKeyboardMaker();
            sendMessage.setReplyMarkup(inlineKeyboardMaker.createInlineKeyboard());
        }

        log.debug("OutputData: " + "chatId=" + sendMessage.getChatId() + " data=" + sendMessage.getText());

        logger(update, "user_requests");

        return sendMessage;
        //}

        //return getSendMessageToBlockedUser(update, chatId);
    }

    private void logger(Update update, String fileName) {
        //WriteToLog writeToLog = new WriteToLog("telegram", fileName);
        final String chatId = update.getMessage().getChatId().toString();
        String data = update.getMessage().getText();
        String firstName = update.getMessage().getFrom().getFirstName();
        String userName = update.getMessage().getFrom().getUserName();
        //writeToLog.writeLog("chatId: " + chatId + " data=" + data + " telegramUserName: " + userName + " firstName: " + firstName);
    }

    @NotNull
    private SendMessage getSendMessageToBlockedUser(Update update, String chatId) {
        logger(update, "blocked_users");

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Вам не разрешено пользоваться этим ботом, свяжитесь с разработчиком");
        return sendMessage;
    }

/*    private boolean validateUser(String chatId) {
        List<TelegramUser> userList = getUserList();
        if (userList == null) return false;

        return userList.stream().anyMatch(user -> chatId.equals(user.getTelegramId()));
    }

    @Nullable
    private List<TelegramUser> getUserList() {
        TelegramUsers telegramUsers = YamlParser.parse(TelegramUsers.class, TELEGRAM_USERS_CONFIG_YAML);

        List<TelegramUser> userList = telegramUsers.getTelegramUsers();
        if (Utils.nullOrEmpty(userList)) return null;
        return userList;
    }*/
}
