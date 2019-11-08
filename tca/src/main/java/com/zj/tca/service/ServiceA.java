/**
 * Copyright (C), 2019
 * FileName: ServiceA
 * Author:   zhangjian
 * Date:     2019/11/7 13:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.tca.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.zj.tca.invoke.ServiceB;
import com.zj.tca.invoke.ServiceC;
import com.zj.tca.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

@RestController
public class ServiceA {

    @Autowired
    private PersonMapper personMapper; //本地db操作

    @Autowired
    private ServiceB serviceB;//远程B模块业务

    @Autowired
    private ServiceC serviceC;//远程C模块业务

    @PostMapping("/addPerson")
    @LcnTransaction //分布式事务注解
//    @Transactional //本地事务注解
    public String addPerson(String name,int age) throws ExecutionException, InterruptedException {
        ExecutorService exc = Executors.newCachedThreadPool();

        int insert = personMapper.insert(name);

        //线程情况下，分布式事务不起作用。但现实情况中这种情况一般会使用消息确保型方案取代分布式事务
        FutureTask callableTask = (FutureTask) exc.submit(new Callable() {
            @Override
            public Object call() {
                int i = serviceB.addUser(name, age);
                return i;
            }
        });

        System.out.println("futureTask:"+callableTask.get());

        int s = serviceC.addName(name);
        System.out.println(""+insert+s);
        
        //发生错误，此时服务B不可回溯，服务C可回溯
        int ii = 10/0;
        
        return insert + " ==== " +s;
    }
}
