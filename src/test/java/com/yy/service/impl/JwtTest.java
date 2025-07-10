package com.yy.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yy.pojo.Coupon;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName JwtTest
 * @Description jwt测试类
 * @Author yangFeng
 * @Date 2025/6/8 15:23
 * @Version 1.0
 */
@Slf4j
public class JwtTest {
    @Test
    void testCreateToken(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("userName","张三");
        String token = JWT.create().withClaim("user", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .sign(Algorithm.HMAC256("bigEvent"));
        System.out.println(token);
    }

    @Test
    void testParse() {
        //定义字符串,模拟用户传递过来的token

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoxLCJ1c2VyTmFtZSI6IuW8oOS4iSJ9LCJleHAiOjE3NDk0NTQxOTZ9.wZ57HuiwTmZPHtDOGnEOHe0Fo62YO4YGkdS5QOs6X6s";

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("bigEvent")).build();

        DecodedJWT decodedJWT = jwtVerifier.verify(token);//验证token,生成一个解析后的JWT对象
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));

        //如果篡改了头部和载荷部分的数据,那么验证失败
        //如果秘钥改了,验证失败
        //token过期
    }
    @Test
    void testListSet(){
        List<Coupon> list = new ArrayList<>();
        list.add(new Coupon(1,"优惠券1"));
        list.add(new Coupon(2,"优惠券2"));
        log.info("设置前数据为:{}",list);
        list.stream()
                .peek(coupon -> coupon.setType(100))
                .toList();
        log.info("设置后数据为:{}",list);
    }
}
