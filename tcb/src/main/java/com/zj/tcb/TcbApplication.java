package com.zj.tcb;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDistributedTransaction//加入分布式事务
@EnableEurekaClient//表示自己是一个 eureka 客户端
@EnableDiscoveryClient//表示可以去 eureka 服务器发现另一个客户端
public class TcbApplication {

    public static void main(String[] args) {
        SpringApplication.run(TcbApplication.class, args);
    }

}
