package com.yy.filter;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.yy.config.BaseConstant;
import com.yy.config.WhiteListConfig;
import com.yy.exception.AuthException;
import com.yy.utils.JwtUtil;
import io.gitee.loulan_yxq.owner.core.exception.AssertException;
import io.gitee.loulan_yxq.owner.core.tool.AssertTool;
import io.gitee.loulan_yxq.owner.core.tool.ObjectTool;
import io.gitee.loulan_yxq.owner.core.tool.StrTool;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/*********************************************************
 ** 认证过滤器验证token有效性
 ** <br><br>
 ** @ClassName: JwtAuthFilter
 ** @author: yangfeng
 ** @date: 2025/7/17 15:36
 ** @version: 1.0.0
 *********************************************************/
@Configuration
@Slf4j
public class JwtAuthFilter extends OncePerRequestFilter {
    @Resource
    private WhiteListConfig whiteListConfig;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private HandlerExceptionResolver handlerExceptionResolver;
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {

        return whiteListConfig.getWhiteList().stream()
                .anyMatch(path -> new AntPathMatcher().match(path, request.getRequestURI()));
    }// 注入解析器
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("拦截路径: {}", request.getRequestURI());
        //验证token
        try {
            //令牌验证
            String token = request.getHeader("Authorization");
            AssertTool.notBlank(token,"令牌不能为空");
            //从redis中获取相同的token
            Map<String, Object> claims = JwtUtil.parseToken(token);
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            Integer userId = (Integer) claims.get(BaseConstant.USER_ID);
            String userName = (String) claims.get(BaseConstant.USERNAME);
            String redisToken = operations.get(BaseConstant.USER_TOKEN+userId);
            if(StrTool.isBlank(redisToken)){
                throw new AuthException("token已过期");
            }
            if(!ObjectTool.equals(token,redisToken)){
                throw new AuthException("token已过期");
            }
           // 根据用户名获取security所需的用户信息
        } catch (AssertException asse) {
            handlerExceptionResolver.resolveException(request, response, null, asse);
        } catch (AuthException ae) {
            throw ae;
        } catch (TokenExpiredException tee) {
            //http响应状态码为401
            handlerExceptionResolver.resolveException(request, response, null, new AuthException("token已过期", tee));
            //不放行
        }catch (Exception e) {
            //http响应状态码为401
            throw new AuthException("用户未登录",e);
            //不放行
        }
    }
}
