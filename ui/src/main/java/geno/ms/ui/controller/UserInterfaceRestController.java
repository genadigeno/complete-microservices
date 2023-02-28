package geno.ms.ui.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RefreshScope
/**
 * @apiNote: The property bindings made with the `@ConfigurationProperties` annotation
 * do not need `@RefreshScope` annotation to be refreshed.
 * */
public class UserInterfaceRestController {
//    @Value("${custom.prop.version}")
    private String customProperty;
    @Value("${application.number}")
    private String appNumber;

    @GetMapping
    public String api(){
        return "APP: #"+appNumber+", api: "+customProperty;
    }
}
