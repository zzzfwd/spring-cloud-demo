package com.example.consumer2.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "spring-cloud-producer", fallback = HelloRemote2Hystrix.class)
public interface HelloRemote2 {

    @RequestMapping("/hello")
    String hello(@RequestParam String name);

}
