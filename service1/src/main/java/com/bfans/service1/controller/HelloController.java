package com.bfans.service1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author lwb
 * @date 2018-12-17
 */
@RestController
@RequestMapping("/")
public class HelloController {

    @PostMapping(value = "/hello")
    public String hello(@RequestParam(value = "name", required = false) String name) {
        return "hello " + Optional.ofNullable(name).orElse("world");
    }

}
