package com.wang.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wang.springcloud.repository.Dept;
import com.wang.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    DeptService deptService;

    @Autowired
    DiscoveryClient client;

    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "getHystrix")
    public Dept queryDeptById(@PathVariable("id") Long id) {
        Dept dept = deptService.queryDeptById(id);
        if (dept == null){
            throw new RuntimeException("Get Service Error!Result can't be null!");
        }

        return dept;
    }


    // 备选方案
    public Dept getHystrix(@PathVariable("id") Long id) {
        return new Dept().setDeptNo(id).setDname("Hystrix Service activate!").setDbSource("no db source");
    }


}
