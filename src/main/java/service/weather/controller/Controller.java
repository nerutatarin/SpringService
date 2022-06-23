package service.weather.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.weather.service.WeatherService;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/weather/api/v0")
//https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}
@Validated
public class Controller {
    private WeatherService weatherService;

    public Controller(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/status")
    public ResponseEntity getStatus() {
        return checkStatus();
    }

    private ResponseEntity<String> checkStatus() {
        try {
            return ok("Сервер работает");
        } catch (Exception ex) {
            return badRequest().body("Сервер не работает " + ex);
        }
    }
}
