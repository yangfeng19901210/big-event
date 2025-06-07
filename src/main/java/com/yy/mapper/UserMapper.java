package com.yy.mapper;

import com.yy.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;

/**
* @author yangFeng
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2025-06-07 19:45:47
* @Entity com.yy.pojo.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where username=#{userName}")
    User getByUserName(String userName);
    @Insert("insert into user(username,password,create_time,update_time)" +
            " values(#{userName},#{password},now(),now())")
    void add(String userName, String password);

    @Insert("insert into user(username,password,create_time,update_time)" +
            " values(#{userName},#{password},#{createTime},#{updateTime})")
    void addV1(String userName, String password, LocalDateTime createTime, LocalDateTime updateTime);

}




