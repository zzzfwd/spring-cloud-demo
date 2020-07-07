package com.example.consumer.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("spring-cloud-producer")
public interface HelloRemote {

    @RequestMapping("/hello")
    public String hello(@RequestParam String name);

}
