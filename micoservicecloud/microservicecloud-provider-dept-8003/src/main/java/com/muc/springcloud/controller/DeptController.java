package com.muc.springcloud.controller;

import com.muc.springcloud.entities.Dept;
import com.muc.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    // 服务发现
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptService.get(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> list(){
        return deptService.list();
    }

    @GetMapping("/dept/discovery")
    public Object discovery(){
        // 获取在 Eureka 中注册的名称
        List<String> services = client.getServices();
        System.out.println("--------->"+services);

        // 获取指定的注册服务了的信息
        List<ServiceInstance> serList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance si:
                serList) {
            System.out.println(si.getServiceId()+"\t"+si.getHost()+"\t"+si.getPort()
            +"\t"+si.getUri());
        }
        return this.client;
    }
}
