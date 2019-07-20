package com.muc.springcloud;

import com.muc.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

// @RibbonClient 不能放在@ComponentScan所扫描的当前包下以及子包下,也就是 @SpringBootApplication包下以及子包下
// 在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效
@SpringBootApplication
@EnableEurekaClient // 开启 Eureka
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MySelfRule.class)
@EnableFeignClients(basePackages= {"com.muc.springcloud"})
public class DeptConsumer80_feign_App {
    public static void main(String[] args){
        SpringApplication.run(DeptConsumer80_feign_App.class,args);
    }
}
