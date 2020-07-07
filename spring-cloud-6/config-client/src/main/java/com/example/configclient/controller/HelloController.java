package com.example.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${demo.hello}")
    private String hello;

    @RequestMapping("/hello")
    public String hello() {
        return this.hello;
    }

}
