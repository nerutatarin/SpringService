package app.voteservice.service.telegrambot.handlers;

import app.voteservice.service.telegrambot.commands.Commands;
import app.voteservice.service.telegrambot.commands.CommandsFactory;
import org.slf4j.Logger;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.slf4j.LoggerFactory.getLogger;

class CallBackHandler implements Handler {
    private static final Logger log = getLogger(CallBackHandler.class);

    @Override
    public SendMessage getMessage(Update update) {
        CallbackQuery callbackQuery = update.getCallbackQuery();

        final String chatId = callbackQuery.getMessage().getChatId().toString();

        //if (validateUser(chatId)) {
            String data = callbackQuery.getData();
            log.debug("InputData: " + "chatId=" + chatId + " data=" + data);

            Commands commands = CommandsFactory.getInstance(data);
            SendMessage sendMessage = commands.execute(chatId, data);
            log.debug("OutputData: " + "chatId=" + sendMessage.getChatId() + " data=" + sendMessage.getText());

            logger(update, "user_requests");

            return sendMessage;
        //}

       /* logger(update, "blocked_users");

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Вам не разрешено пользоваться этим ботом, свяжитесь с разработчиком");
        return sendMessage;*/
    }

    private void logger(Update update, String fileName) {
        //WriteToLog writeToLog = new WriteToLog("telegram", fileName);
        final String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        String data = update.getCallbackQuery().getMessage().getText();
        String firstName = update.getCallbackQuery().getMessage().getFrom().getFirstName();
        String userName = update.getCallbackQuery().getMessage().getFrom().getUserName();
        //writeToLog.writeLog("chatId: " + chatId + " data=" + data + " telegramUserName: " + userName + " firstName: " + firstName);
    }

   /* private boolean validateUser(String chatId) {
        List<TelegramUser> userList = getUserList();
        if (userList == null) return false;

        return userList.stream().anyMatch(user -> chatId.equals(user.getTelegramId()));
    }

    @Nullable
    private List<TelegramUser> getUserList() {
        //TelegramUsers telegramUsers = YamlParser.parse(TelegramUsers.class, TELEGRAM_USERS_CONFIG_YAML);

        List<TelegramUser> userList = telegramUsers.getTelegramUsers();
        if (Utils.nullOrEmpty(userList)) return null;
        return userList;
    }*/
}
