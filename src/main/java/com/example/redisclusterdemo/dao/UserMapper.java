package com.example.redisclusterdemo.dao;


import com.example.redisclusterdemo.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Delete("delete from usertable where name = #{name}")
    int deleteByName(String name);

    @Insert("insert into usertable values(#{id}, #{name})")
    int insert(User record);

    @Select("select * from usertable where name = #{name}")
    User selectByName(String name);

    @Update("update usertable set name = #{name} where id = #{id}")
    int update(User record);

}