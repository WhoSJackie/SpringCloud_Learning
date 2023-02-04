package com.wang.springcloud.service;

import com.wang.springcloud.repository.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptService {

    boolean addDept(Dept dept);

    Dept queryDeptById( @Param("id") Long id);

    List<Dept> queryDept();

}
