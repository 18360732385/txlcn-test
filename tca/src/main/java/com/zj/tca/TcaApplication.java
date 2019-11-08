package com.zj.tca;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDistributedTransaction
@EnableEurekaClient//表示自己是一个 eureka 客户端
@EnableDiscoveryClient//表示可以去 eureka 服务器发现另一个客户端
@EnableFeignClients
public class TcaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TcaApplication.class, args);
    }

}
