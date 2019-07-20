package com.muc.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.muc.springcloud.dao")
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient // 开启服务发现
@SpringBootApplication
public class DeptProvider8003_App {
    public static void main(String[] args){
        SpringApplication.run(DeptProvider8003_App.class,args);
    }
}
