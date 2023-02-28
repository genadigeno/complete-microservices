package geno.ms.ui;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${rabbitmq.binding.routing-key}")
    private String routingKey;
    @Value("${rabbitmq.exchange.name}")
    private String topicExchangeName;
    @Value("${rabbitmq.queue.name}")
    private String queueName;
    @Value("${spring.rabbitmq.username}")
    private String rabbitMQUsername;
    @Value("${spring.rabbitmq.password}")
    private String rabbitMQPassword;
    @Value("${spring.rabbitmq.host}")
    private String rabbitMQHost;
    @Value("${spring.rabbitmq.port}")
    private int rabbitMQPort;

    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(rabbitMQHost, rabbitMQPort);
        connectionFactory.setUsername(rabbitMQUsername);
        connectionFactory.setPassword(rabbitMQPassword);
        return connectionFactory;
    }

    @Bean
    public Queue queue(){
        return new Queue(queueName, false);
    }

    @Bean
    public Exchange exchange(){
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    public Binding binding(){
        BindingBuilder.GenericArgumentsConfigurer genericArgumentsConfigurer = BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routingKey);
        return genericArgumentsConfigurer.noargs();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        //rabbitTemplate.setMessageConverter(converter());
        return new RabbitTemplate(connectionFactory);
    }
}
