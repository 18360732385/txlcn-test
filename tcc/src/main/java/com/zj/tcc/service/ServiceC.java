/**
 * Copyright (C), 2019
 * FileName: ServiceB
 * Author:   zhangjian
 * Date:     2019/11/7 16:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.tcc.service;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.zj.tcc.mapper.NameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceC {
    @Autowired
    private NameMapper nameMapper;

    @LcnTransaction(propagation = DTXPropagation.SUPPORTS)//被调用的服务需要加参数
    @Transactional  //本地事务注解
    @PostMapping("/addName")
    public int addUser(String name){
        int insert = nameMapper.insert(name);
        System.out.println("结果："+insert);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return  insert;
    }
}
