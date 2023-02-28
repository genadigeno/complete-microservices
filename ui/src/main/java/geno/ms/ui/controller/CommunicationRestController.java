package geno.ms.ui.controller;

import geno.ms.ui.controller.message.ExtendedMessage;
import geno.ms.ui.feign.DataStreamClient;
import geno.ms.ui.feign.DataStreamModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RefreshScope
/* Refreshing The Configuration Properties Over Spring Cloud Bus:
*   - Spring Cloud Bus enables broadcasting the state changes among
*     the services over a message broker like 'Kafka' or 'RabbitMQ'.
* */
public class CommunicationRestController {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.binding.routing-key}")
    private String routingKey;

    private final DataStreamClient dataStreamClient;
    private final RabbitTemplate rabbitTemplate;

    public CommunicationRestController(DataStreamClient dataStreamClient, RabbitTemplate rabbitTemplate) {
        this.dataStreamClient = dataStreamClient;
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/communicate")
    public ResponseEntity<Object> communication(){
        DataStreamModel model = dataStreamClient.loadData(UUID.randomUUID().toString());
        return ResponseEntity.ok(model);
    }

    @GetMapping("/communicate/list")
    public ResponseEntity<Object> communications(){
        return ResponseEntity.ok(dataStreamClient.loadDatas());
    }

    @PostMapping("/send")
    public String send(){
        String msg = "msg";
        ExtendedMessage extendedMessage = new ExtendedMessage(msg.getBytes(StandardCharsets.UTF_8));

        Map<String, String> metaData = new HashMap<>();
        metaData.put("author", "Geno Mumladze");
        extendedMessage.setMetaData(metaData);

        rabbitTemplate.convertAndSend(exchange, routingKey, extendedMessage);//send a message to queue

        System.out.println("message sent");
        return "sent";
    }
}
