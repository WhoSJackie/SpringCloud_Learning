package com.wang.springcloud.controller;

import com.wang.springcloud.repository.Dept;
import com.wang.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    DeptService deptService;

    @Autowired
    DiscoveryClient client;

    @PostMapping("/add")
    public Boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/get/{id}")
    public Dept queryDeptById(@PathVariable("id") Long id) {
        return deptService.queryDeptById(id);
    }

    @GetMapping("/list")
    public List<Dept> queryDept() {
        return deptService.queryDept();
    }

    // 获取服务注册实例信息
    @GetMapping("/discovery")
    public Object getDiscovery(){
        List<String> services = client.getServices();
        System.out.println("discovery=>"+services);
        List<ServiceInstance> instances = client.getInstances("springcloud-provider-dept");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri()+"\t"+
                    instance.getMetadata()
            );
        }

        return this.client;
    }

}
