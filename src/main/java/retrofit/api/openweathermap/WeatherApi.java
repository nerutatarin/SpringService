package retrofit.api.openweathermap;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherApi {

    @GET("/data/2.5/weather?")
    Call<Weather> getIpJson();


}
