package com.example.consumer2.controller;

import com.example.consumer2.remote.HelloRemote2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consumer2Controller {

    @Autowired
    private HelloRemote2 helloRemote2;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return helloRemote2.hello(name);
    }

}
