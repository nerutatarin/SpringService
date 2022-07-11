/*
package app.burlesqueservice.connection;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static app.burlesqueservice.utils.Thesaurus.BASE_URL;
import static app.burlesqueservice.utils.Thesaurus.LOGIN_URL_EXTENSION;
import static java.util.Objects.requireNonNull;

@Service
public class Connection {

    public Map<String, String> getCookies() {
        Map<String, String> authParams = new HashMap<>();
        authParams.put("action", "processXdget");
        authParams.put("xdgetId", "99945");
        authParams.put("params[action]", "login");
        authParams.put("params[email]", "zar.olga2015@yandex.ru");
        authParams.put("params[password]", "ax0629527ax");

        Response response = getResponse(authParams);
        return requireNonNull(response).cookies();
    }

    private Response getResponse(Map<String, String> authParams) {
        try {
            return connect(BASE_URL + LOGIN_URL_EXTENSION)
                    .data(authParams)
                    .method(POST)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
*/
