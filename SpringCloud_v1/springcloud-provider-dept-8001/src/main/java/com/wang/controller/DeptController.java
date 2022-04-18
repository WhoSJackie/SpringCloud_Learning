package com.wang.controller;

import com.wang.repository.Dept;
import com.wang.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    DeptService deptService;

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


}
