package com.zj.tm;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableTransactionManagerServer
@EnableEurekaClient//表示自己是一个 eureka 客户端
@EnableDiscoveryClient//表示可以去 eureka 服务器发现另一个客户端
public class TmApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmApplication.class, args);
    }

}
