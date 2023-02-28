package geno.ms.configserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigServerRestController {

    @GetMapping
    public String index(){
        return "config server";
    }
}
