package com.example.consulconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 获取所有已注册的名为 "service-producer" 的服务
     *
     * @return 所有已注册的名为 "service-producer" 的服务
     */
    @RequestMapping("/services")
    public Object services() {
        return discoveryClient.getInstances("service-producer");
    }

    /**
     * 从所有已注册的名为 "service-producer" 的服务中选择一个(轮询)
     *
     * @return 其中一个名为 "service-producer" 的服务
     */
    @RequestMapping("/discover")
    public Object discover() {
        return loadBalancerClient.choose("service-producer").getUri().toString();
    }

}
