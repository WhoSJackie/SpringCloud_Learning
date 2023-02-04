package com.wang.springcloud.controller;

import com.wang.springcloud.repository.Dept;
import com.wang.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @Autowired
    private DeptClientService deptClientService;


    @RequestMapping("/add")
    public Boolean addDept(Dept dept){
        return deptClientService.addDept(dept);
    }

    @RequestMapping("/get/{deptId}")
    public Dept getDept(@PathVariable("deptId") Long id){
        return deptClientService.getDept(id);
    }

    @RequestMapping("/list")
    public List<Dept> getList(){
        return deptClientService.getList();
    }


}
