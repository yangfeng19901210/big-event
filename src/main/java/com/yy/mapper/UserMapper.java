package com.yy.mapper;

import com.yy.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{userName}")
    User getByUserName(String userName);
    @Insert("insert into user(username,password,create_time,update_time)" +
            " values(#{userName},#{password},now(),now())")
    void add(String userName, String password);

    @Insert("insert into user(username,password,create_time,update_time)" +
            " values(#{userName},#{password},#{createTime},#{updateTime})")
    void addV1(String userName, String password, LocalDateTime createTime,LocalDateTime updateTime);
}
