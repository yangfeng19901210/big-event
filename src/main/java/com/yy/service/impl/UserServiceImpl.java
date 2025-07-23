package com.yy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.common.BaseStorage;
import com.yy.pojo.SysUserRole;
import com.yy.pojo.User;
import com.yy.service.SysUserRoleService;
import com.yy.service.UserService;
import com.yy.mapper.UserMapper;
import com.yy.utils.Md5Util;
import com.yy.vo.in.UpUserInVO;
import com.yy.vo.in.UpdatePwdInVO;
import io.gitee.loulan_yxq.owner.core.bean.BeanTool;
import io.gitee.loulan_yxq.owner.core.tool.AssertTool;
import io.gitee.loulan_yxq.owner.core.tool.ObjectTool;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
* @author yangFeng
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2025-06-07 19:45:47
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Resource
    private UserMapper userMapper;
    @Resource
    private SysUserRoleService sysUserRoleService;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Override
    public Boolean register(String userName, String password) {
        User u = getByUserName(userName);
        AssertTool.isNull(u,"用户名已被占用");
        u = new User();
        u.setUsername(userName);
        u.setPassword(passwordEncoder.encode(password));
        return save(u);
    }
    /** 根据用户名查询用户信息
     * @Description TODO
     * @Author yangfeng
     * @Date 2025/6/7 12:01
     * @Param userName
     * @Return com.yy.pojo.User
     */
    @Override
    public User getByUserName(String userName) {
        return lambdaQuery().eq(User::getUsername, userName).one();
    }

    @Override
    public Boolean updateUserInfo(UpUserInVO vo) {
        User user = BeanTool.copy(vo, User.class);
        return updateById(user);
    }

    @Override
    public Boolean updateAvatar(String avatarUrl) {
        User u = new User();
        u.setId(BaseStorage.getUserId());
        u.setUserPic(avatarUrl);
        return updateById(u);
    }

    @Override
    public Boolean updatePwd(UpdatePwdInVO vo) {
        AssertTool.isFalse(ObjectTool.equals(vo.getOldPwd(),vo.getNewPwd()),"新密码不可和原始密码一样");
        AssertTool.isTrue(ObjectTool.equals(vo.getNewPwd(),vo.getRePwd()),"新密码和确认密码不一致");
        Long userId = BaseStorage.getUserId();
        User user = getById(userId);
        AssertTool.notNull(user,"用户不存在");
        AssertTool.isTrue(ObjectTool.equals(user.getPassword(),Md5Util.getMD5String(vo.getOldPwd())),"原始密码错误");
        user.setPassword(Md5Util.getMD5String(vo.getNewPwd()));
        return updateById(user);
    }

    @Override
    public boolean addRolesToUser(Long userId, List<Long> roleIds) {
        List<SysUserRole> userRoles = roleIds.stream().map(roleId -> {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(userId);
            sysUserRole.setRoleId(roleId);
            return sysUserRole;
        }).toList();
        return sysUserRoleService.saveBatch(userRoles);
    }

}




