package com.wang.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient // 启动后服务自动注册到eureka
// @EnableDiscoveryClient // 服务发现
@EnableHystrix
public class DeptProvider_hystrix_8001 {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_hystrix_8001.class,args);
    }

    // 增加一个servlet bean
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean<HystrixMetricsStreamServlet> servletBean = new ServletRegistrationBean<>(new HystrixMetricsStreamServlet());
        servletBean.addUrlMappings("/actuator/hystrix.stream");
        return servletBean;
    }

}
