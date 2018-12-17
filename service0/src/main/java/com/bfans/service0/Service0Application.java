package com.bfans.service0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 1. 使用DiscoveryClient查找服务：需要注解@EnableDiscoveryClient
 * 2. 使用支持Ribbon的RestTemplate查找服务：不需要@EnableDiscoveryClient
 * 3. 使用Netflix Feign客户端调用服务：需要注解@EnableFeignClients
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Service0Application {

    /**
     * 2. 使用支持Ribbon的RestTemplate查找服务
     */
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Service0Application.class, args);
    }
}
