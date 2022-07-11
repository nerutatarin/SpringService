package app.elschoolservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotBlank;

@Configuration("elschool")
@ConfigurationProperties(prefix = "web-parse-service.elschool")
public class ElschoolServiceConfig {

    @NotBlank
    private String url;
    @NotBlank
    private String login;
    @NotBlank
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
