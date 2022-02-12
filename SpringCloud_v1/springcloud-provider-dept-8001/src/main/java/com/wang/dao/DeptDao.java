package com.wang.dao;

import com.wang.repository.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {

    boolean addDept(Dept dept);

    Dept queryDeptById( @Param("deptId") Long id);

    List<Dept> queryDept();

}
