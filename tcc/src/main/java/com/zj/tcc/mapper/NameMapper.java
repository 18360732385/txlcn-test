package com.zj.tcc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NameMapper {
    @Insert("insert into name(name) values(#{name})")
    int insert(String name);
}
