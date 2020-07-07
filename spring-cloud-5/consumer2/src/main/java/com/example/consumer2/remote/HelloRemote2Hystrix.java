package com.example.consumer2.remote;

import org.springframework.stereotype.Component;

@Component
public class HelloRemote2Hystrix implements HelloRemote2 {

    @Override
    public String hello(String name) {
        return "Hello " + name + ", this is HelloRemoteHystrix2. Your producer maybe down.";
    }

}
