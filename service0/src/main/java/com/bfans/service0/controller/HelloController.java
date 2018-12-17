package com.bfans.service0.controller;

import com.bfans.service0.clients.Service1Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lwb
 * @date 2018-12-17
 */
@RestController
@RequestMapping("/")
public class HelloController {

    private static final String SERVICE_1 = "service1";

    /**
     * 1. 使用DiscoveryClient查找服务
     */
    @Autowired
    private DiscoveryClient discoveryClient;


    /**
     * 2. 使用支持Ribbon的RestTemplate查找服务
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 3. 使用Netflix Feign客户端调用服务
     */
    @Autowired
    private Service1Client service1Client;


    /**
     * 1. 使用DiscoveryClient查找服务
     */
    @GetMapping("/helloByDC")
    public String helloByDiscoveryClient() {
        List<ServiceInstance> instances = discoveryClient.getInstances(SERVICE_1);

        if (instances.size() == 0) {
            return null;
        }
        ServiceInstance serviceInstance = instances.get(0);
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> map = new HashMap<>();
        map.put("name", "discoverClient");
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                serviceInstance.getUri() + "/hello?name={name}",
                HttpMethod.POST,
                null,
                String.class,
                map);

        return responseEntity.getBody();
    }

    /**
     * 2. 使用支持Ribbon的RestTemplate查找服务
     */
    @GetMapping("/helloByRb")
    public String helloByRibbon() {
        Map<String, String> map = new HashMap<>();
        String s = restTemplate.postForObject(
                "http://" + SERVICE_1 + "/hello?name={name}",
                null,
                String.class,
                "ribbon");
        return s;
    }

    /**
     * 3. 使用Netflix Feign客户端调用服务
     */
    @GetMapping("/helloByFeign")
    public String helloByFeign() {
        return service1Client.hello("feign");
    }


}
