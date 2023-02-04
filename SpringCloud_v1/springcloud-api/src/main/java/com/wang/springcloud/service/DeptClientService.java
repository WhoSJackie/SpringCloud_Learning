package com.wang.springcloud.service;

import com.wang.springcloud.repository.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
@FeignClient(name = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = HytrixCallBackFactory.class)
public interface DeptClientService {

    @PostMapping("/dept/add")
     Boolean addDept(Dept dept);

    @GetMapping("/dept/get/{deptId}")
     Dept getDept(@PathVariable("deptId") Long id);

    @GetMapping("/dept/list")
     List<Dept> getList();


}
