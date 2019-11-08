package com.zj.tcb.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into user(name,age) values(#{name},#{age})")
    int insert(String name,int age);
}
