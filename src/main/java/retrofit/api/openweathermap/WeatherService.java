package retrofit.api.openweathermap;

import org.apache.log4j.Logger;
import retrofit.BasicClient;
import retrofit.api.myip.response.IPAddress;

import static org.apache.log4j.Logger.getLogger;

public class WeatherService extends BasicClient {
    private static final Logger log = getLogger(WeatherService.class);

    //https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}
    private final String baseUrl = "https://api.openweathermap.org";
    private final WeatherApi api = getApi(WeatherApi.class, baseUrl);

    public IPAddress getIpJson() {
        return getResponse(api.getIpJson());
    }

    @Override
    protected Logger getLog() {
        return log;
    }
}
