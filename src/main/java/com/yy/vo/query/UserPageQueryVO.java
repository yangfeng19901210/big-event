package com.yy.vo.query;

import com.yy.common.entity.PageQuery;
import lombok.Data;

/**
 * 分页查询用户列表参数
 *
 * @ClassName UserPageQueryVO
 * @Author yangfeng
 * @Date 2025/7/30 8:51
 * @Version 1.0
 */
@Data
public class UserPageQueryVO extends PageQuery {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 昵称
     */
    private String nickName;
}