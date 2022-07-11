/*
package app.burlesqueservice.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import app.burlesqueservice.service.BurlesqueParse;
import app.burlesqueservice.service.password.PasswordGenerator;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/parse-service/api/v0")
@Validated
public class WebController {
    private final BurlesqueParse burlesqueParse;
    private PasswordGenerator passwordGenerator;

    public WebController(BurlesqueParse burlesqueParse, PasswordGenerator passwordGenerator) {
        this.burlesqueParse = burlesqueParse;
        this.passwordGenerator = passwordGenerator;
    }

    @GetMapping("/burlesque")
    public void getBurlesque(){
        burlesqueParse.getPage();
    }

    @GetMapping("pswd_gen_{length}")
    public void getTest(@PathVariable int length){
        System.out.println("pas: " + generatePassword(length));
    }

    private String generatePassword(int length) {
        return new PasswordGenerator.PasswordGeneratorBuilder()
                .useDigits(true)
                .build()
                .generate(length);
    }

    @GetMapping("/status")
    public ResponseEntity getStatus() {
        try {
            return ok("Сервер работает");
        } catch (Exception ex) {
            return badRequest().body("Сервер не работает " + ex);
        }
    }
}
*/
