package com.bfans.serviceszone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceszoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceszoneApplication.class, args);
    }
}
