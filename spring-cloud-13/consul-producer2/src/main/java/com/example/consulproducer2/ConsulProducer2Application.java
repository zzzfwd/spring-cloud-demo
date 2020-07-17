package com.example.consulproducer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsulProducer2Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsulProducer2Application.class, args);
    }

}
