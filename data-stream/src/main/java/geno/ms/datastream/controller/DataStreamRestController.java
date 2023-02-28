package geno.ms.datastream.controller;

import geno.ms.datastream.model.DataStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RefreshScope
public class DataStreamRestController {
    @Value("${message.version}")
    private String messageProperty;

    @GetMapping
    public String api(){
        return "message.version: "+messageProperty;
    }

    @Value("${eureka.client.serviceUrl.defaultZone}")
    private String eureka;

    @GetMapping("/eureka")
    public String eureka(){
        return eureka;
    }

    @GetMapping("/load/{uuid}")
    public DataStream loadDataStream(@PathVariable String uuid){
        return new DataStream(uuid, LocalDate.now());
    }

    @GetMapping("/load")
    public List<DataStream> geDataStreams(){
        LocalDate date = LocalDate.now();
        return List.of(
                new DataStream("1", date),
                new DataStream("2", date),
                new DataStream("3", date)
        );
    }
}
