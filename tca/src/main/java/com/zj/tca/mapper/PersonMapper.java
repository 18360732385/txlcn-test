package com.zj.tca.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapper {
    @Insert("insert into persons(id,name) values(null,#{name})")
    int insert(String name);
}
