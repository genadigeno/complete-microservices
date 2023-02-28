package geno.ms.datastream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataStreamRestControllerIndex {

    @GetMapping
    public String index(){
        return "data-stream";
    }
}
