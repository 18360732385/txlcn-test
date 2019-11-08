package com.zj.tca.invoke;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "tcb")
public interface ServiceB {

    @PostMapping("/addUser")
    int addUser(@RequestParam("name") String name, @RequestParam("age")int age);
}
