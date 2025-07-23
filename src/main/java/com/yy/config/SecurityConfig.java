package com.yy.config;

import com.yy.filter.JwtAuthFilter;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

/*********************************************************
 ** security配置文件
 ** <br><br>
 ** @ClassName: SecurityConfig
 ** @author: yangfeng
 ** @date: 2025/7/22 9:00
 ** @version: 1.0.0
 *********************************************************/
@Configuration
//开启方法级的安全控制
@EnableMethodSecurity
public class SecurityConfig {
    @Resource
    private JwtAuthFilter jwtAuthFilter;
    @Resource
    private WhiteListConfig whiteListConfig;
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(whiteListConfig.getWhiteList().toArray(new String[0])).permitAll()// 放行登录页及静态资源
                        .anyRequest().authenticated() // 其他请求需认证
                )
    //            .userDetailsService(sysUserDetailsService)
    //            .formLogin(Customizer.withDefaults())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
