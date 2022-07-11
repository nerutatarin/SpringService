package app.voteservice.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "vote-service.telegram-config.users")
@Validated
public class TelegramUsers {

    @NotEmpty
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public boolean isAllowUser(String userId) {
        return getUsers()
                .stream()
                .anyMatch(user -> userId.equals(user.getTelegramId()));
    }
}
