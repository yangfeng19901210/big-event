package com.yy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yy.common.entity.PageDTO;
import com.yy.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.vo.in.UpUserInVO;
import com.yy.vo.in.UpdatePwdInVO;
import com.yy.vo.out.UserPageOutVO;
import com.yy.vo.query.UserPageQueryVO;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.URL;

import java.util.List;

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
    /**
     * 更新用户密码
     * @param vo 
     * @Return: java.lang.Boolean
     * @author: yangfeng
     * @date: 2025/6/30 9:47
     **/
    Boolean updatePwd(UpdatePwdInVO vo);
    /**
     * 用户添加角色
     * @param userId 用户id
     * @param roleIds 角色id集合
     * @Return: boolean
     * @author: yangfeng
     * @date: 2025/7/18 9:20
     **/
    boolean addRolesToUser(Long userId, List<Long> roleIds);
    /**
     * 分页获取用户列表
     * @param vo
     * @Return: com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.yy.vo.out.UserPageOutVO>
     * @author: yangfeng
     * @date: 2025/7/30 9:01
     **/
    PageDTO<UserPageOutVO> getUserPageData(@Valid UserPageQueryVO vo);
}
