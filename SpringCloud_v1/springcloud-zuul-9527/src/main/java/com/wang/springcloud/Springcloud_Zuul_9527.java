package com.wang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableZuulProxy
@EnableDiscoveryClient
public class Springcloud_Zuul_9527 {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud_Zuul_9527.class,args);
    }

}
