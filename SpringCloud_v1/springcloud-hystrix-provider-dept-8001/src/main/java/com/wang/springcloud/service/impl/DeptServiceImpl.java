package com.wang.springcloud.service.impl;

import com.wang.springcloud.dao.DeptDao;
import com.wang.springcloud.repository.Dept;
import com.wang.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptDao deptDao;

    @Override
    public boolean addDept( Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryDeptById(Long id) {
        return deptDao.queryDeptById(id);
    }

    @Override
    public List<Dept> queryDept() {
        return deptDao.queryDept();
    }
}
