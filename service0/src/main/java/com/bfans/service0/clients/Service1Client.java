package com.bfans.service0.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 3. 使用Netflix Feign客户端调用服务:
 * service1的客户端接口
 *
 * @author lwb
 * @date 2018-12-17
 */
@FeignClient("service1")
public interface Service1Client {

    @PostMapping(value = "/hello")
    String hello(@RequestParam(value = "name") String name);

}
