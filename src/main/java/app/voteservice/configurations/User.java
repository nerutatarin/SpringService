package app.voteservice.configurations;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class User {

    @NotBlank
    private String title;

    private String phone;
    @NotBlank
    private String telegramId;

    private String telegramUserName;
    @NotNull
    private int rule;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTelegramId() {
        return telegramId;
    }

    public void setTelegramId(String telegramId) {
        this.telegramId = telegramId;
    }

    public String getTelegramUserName() {
        return telegramUserName;
    }

    public void setTelegramUserName(String telegramUserName) {
        this.telegramUserName = telegramUserName;
    }

    public int getRule() {
        return rule;
    }

    public void setRule(int rule) {
        this.rule = rule;
    }
}
