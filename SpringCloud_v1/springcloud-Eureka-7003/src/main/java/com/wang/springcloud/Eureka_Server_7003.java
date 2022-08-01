package com.wang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// 启动后访问localhost:7003 开启监控界面
@SpringBootApplication
@EnableEurekaServer // 服务端启动类，允许别人注册进来
public class Eureka_Server_7003 {

    public static void main(String[] args) {
        SpringApplication.run(Eureka_Server_7003.class,args);
    }

}
