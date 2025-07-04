package com.yy.interceptors;
import com.yy.common.BaseStorage;
import com.yy.config.BaseConstant;
import com.yy.exception.AuthException;
import com.yy.utils.JwtUtil;
import com.yy.utils.ThreadLocalUtil;
import io.gitee.loulan_yxq.owner.core.tool.AssertTool;
import io.gitee.loulan_yxq.owner.core.tool.StrTool;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //令牌验证
        String token = request.getHeader("Authorization");
        AssertTool.notBlank(token,"令牌不能为空");
        //验证token
        try {
            //从redis中获取相同的token
            Map<String, Object> claims = JwtUtil.parseToken(token);
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            Integer userId = (Integer) claims.get(BaseConstant.USER_ID);
            String userName = (String) claims.get(BaseConstant.USERNAME);
            String redisToken = operations.get(BaseConstant.USER_TOKEN+userId);
            if(StrTool.isBlank(redisToken)){
                throw new AuthException("token已过期");
            }
            //将用户id和用户名放入本地线程
            BaseStorage.pushUserId(userId);
            BaseStorage.pushUsername(userName);
            return true;
        } catch (AuthException ae) {
            throw ae;
        } catch (Exception e) {
            //http响应状态码为401
            throw new AuthException("用户未登录",e);
            //不放行
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清空ThreadLocal中的数据
//        ThreadLocalUtil.remove();
        BaseStorage.remove();
    }
}
