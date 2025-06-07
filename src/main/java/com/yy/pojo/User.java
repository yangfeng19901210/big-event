package com.yy.pojo;



import com.yy.common.entity.BaseEntity;
import lombok.Data;

@Data
public class User extends BaseEntity {
    private Integer id;//主键ID
    private String username;//用户名
    private String password;//密码
    private String nickname;//昵称
    private String email;//邮箱
    private String userPic;//用户头像地址

}
