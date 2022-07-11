package app.elschoolservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import app.elschoolservice.service.SchoolService;

import javax.validation.constraints.NotNull;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/school/api/v0")
@Validated
public class Controller {
    private final SchoolService schoolService;

    public Controller(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/logon")
    public void getLogon() {
        schoolService.getLogon();
    }

    @GetMapping("/status")
    public ResponseEntity getStatus() {
        return status();
    }

    @NotNull
    private ResponseEntity<String> status() {
        try {
            return ok("Сервер работает");
        } catch (Exception ex) {
            return badRequest().body("Сервер не работает " + ex);
        }
    }
}
