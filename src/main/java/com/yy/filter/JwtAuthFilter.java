package com.yy.filter;

import com.yy.config.WhiteListConfig;
import com.yy.exception.AuthException;
import com.yy.service.CustomUserDetailsService;
import com.yy.utils.JwtUtil;
import io.gitee.loulan_yxq.owner.core.exception.AssertException;
import io.gitee.loulan_yxq.owner.core.tool.AssertTool;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

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
    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private CustomUserDetailsService customUserDetailsService;
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
            String tokenHeader = request.getHeader("Authorization");
            AssertTool.notBlank(tokenHeader,"令牌不能为空");
            AssertTool.isTrue(tokenHeader.startsWith("Bearer "),"token格式错误");
            String token = tokenHeader.substring(7);
            if(jwtUtil.validateToken(token)){
                String username = jwtUtil.getUsernameFromToken(token);
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );
                SecurityContextHolder.getContext().setAuthentication(auth);
                filterChain.doFilter(request, response);
            }else{
                throw new  AssertException("token无效");
            }
        } catch (AssertException asse) {
            handlerExceptionResolver.resolveException(request, response, null, asse);
        } catch (Exception e) {
            //http响应状态码为401
//            throw new AuthException("用户未登录",e);
            //不放行
            handlerExceptionResolver.resolveException(request, response, null, new AuthException("token无效"));
        }
    }
}
