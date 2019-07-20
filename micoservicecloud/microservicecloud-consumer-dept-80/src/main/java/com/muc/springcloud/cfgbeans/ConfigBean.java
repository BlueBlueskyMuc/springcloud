package com.muc.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced // 获得Rest时加入Ribbon的配置
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    // 修改默认的算法中从服务列表中选取一个要访问的服务
//    @Bean
//    public IRule iRule(){
//        return new RetryRule(); // 随机算法
//    }
}
