package com.example.consumer.remote;

import org.springframework.stereotype.Component;

@Component
public class HelloRemoteHystrix implements HelloRemote {

    @Override
    public String hello(String name) {
        return "Hello " + name + ", this is HelloRemoteHystrix. Your producer is down.";
    }

}
