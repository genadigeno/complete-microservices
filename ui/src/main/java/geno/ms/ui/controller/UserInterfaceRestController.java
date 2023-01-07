package geno.ms.ui.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class UserInterfaceRestController {

    @GetMapping
    public String api(){
        return "ok";
    }
}
