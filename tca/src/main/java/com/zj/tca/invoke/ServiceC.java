/**
 * Copyright (C), 2019
 * FileName: ServiceC
 * Author:   zhangjian
 * Date:     2019/11/7 20:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.tca.invoke;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "tcc")
public interface ServiceC {
    @PostMapping("/addName")
    int addName(String name);
}
