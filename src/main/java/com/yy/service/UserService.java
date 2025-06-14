package com.yy.service;

import com.yy.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.vo.in.UpUserInVO;
import org.hibernate.validator.constraints.URL;

/**
* @author yangFeng
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2025-06-07 19:45:47
*/
public interface UserService extends IService<User> {
    /**
     * @Description 用户注册
     * @Author yangfeng
     * @Date 2025/6/7 12:02
     * @Param userName 用户名
     * @Param password 密码
     * @Return java.lang.Boolean
     */
    Boolean register(String userName, String password);

    /**
     * @Description TODO
     * @Author yangfeng
     * @Date 2025/6/7 12:02
     * @Param userName
     * @Return com.yy.pojo.User
     */
    User getByUserName(String userName);
    /**
    * @description 更新用户基本信息
    * @author yangFeng
    * @date 2025/6/13 21:41
    * @param vo
    * @return java.lang.Boolean
    */
    Boolean updateUserInfo(UpUserInVO vo);
    /**
    * @description 更新当前用户头像
    * @author yangFeng
    * @date 2025/6/14 12:09
    * @param avatarUrl
    * @return java.lang.Boolean
    */
    Boolean updateAvatar(@URL String avatarUrl);
}
