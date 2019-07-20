package com.muc.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {

    // 修改默认的算法中从服务列表中选取一个要访问的服务
    @Bean
    public IRule iRule(){
//        return new RandomRule(); // 随机算法
        return new RandomRule_Muc(); // 自己的轮询算法，每个服务器调用5次
    }
}
