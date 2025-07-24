package com.yy.service.impl;

import com.yy.utils.JwtUtil;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName JwtTest
 * @Description jwt测试类
 * @Author yangFeng
 * @Date 2025/6/8 15:23
 * @Version 1.0
 */
@SpringBootTest
public class JwtTest {
    @Resource
    private JwtUtil jwtUtil;
    @Test
    void testParserToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJndWFueXUiLCJyb2xlcyI6WyJ1c2VyOnVzZXJJbmZvIiwiYXJ0aWNsZTpnZXRQYWdlRGF0YSIsImFydGljbGU6ZGVsZXRlIiwiUk9MRV9BRE1JTiIsIlJPTEVfZGV2ZWxvcGVyIiwiUk9MRV92aXNpdG9yIl0sImlhdCI6MTc1MzMxODgzNywiZXhwIjoxNzUzNDA1MjM3fQ.8Ghxh6OKZlI6KjgSdKUtorrDLRAzvQYFo9thYytH6SA";
        jwtUtil.printTokenInfo(token);
    }

}
