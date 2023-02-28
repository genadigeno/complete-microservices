package geno.ms.datastream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DataStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataStreamApplication.class, args);
    }
}
