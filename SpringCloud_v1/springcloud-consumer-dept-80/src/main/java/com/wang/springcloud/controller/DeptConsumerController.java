package com.wang.springcloud.controller;

import com.wang.repository.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author jiami
 */
@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerController {

    // 提供多种便捷访问远程http的方法,简单的restful服务模板
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX="http://localhost:8001";


    @RequestMapping("/add")
    public Boolean addDept(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping("/get/{deptId}")
    public Dept getDept(@PathVariable("deptId") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping("/list")
    public List<Dept> getList(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }


}
