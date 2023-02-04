package com.wang.springcloud.service;

import com.wang.springcloud.repository.Dept;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HytrixCallBackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable cause) {
        return new DeptClientService() {
            @Override
            public Boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept getDept(Long id) {
                return new Dept().setDeptNo(id)
                        .setDname("id=>"+id+"未找到相关信息，客户端提供了降级的信息，这个服务现在已经被关闭")
                        .setDbSource("no database found!");
            }

            @Override
            public List<Dept> getList() {
                return null;
            }
        };
    }
}
