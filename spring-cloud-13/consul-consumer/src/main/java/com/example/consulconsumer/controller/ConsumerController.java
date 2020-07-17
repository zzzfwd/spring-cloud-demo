package com.example.consulconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/call")
    public String call() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("service-producer");

        System.out.println("服务地址: " + serviceInstance.getUri());
        System.out.println("服务名称: " + serviceInstance.getServiceId());

        String result = new RestTemplate()
                .getForObject(serviceInstance.getUri().toString() + "/hello?name={1}", String.class, "idea");
        System.out.println(result);
        return result;
    }

}
