package com.yy.utils;

import com.yy.config.JwtProperties;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class JwtUtil {

    @Resource
    private JwtProperties jwtProperties;
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // 生成令牌（含角色信息）
    public String generateToken(String username,Long userId, List<String> roles,long ttl) {
        if(ttl <= 0) {
            ttl = jwtProperties.getTtl(); // 如果传入的ttl无效，使用默认配置
        }
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)  // 嵌入角色信息
                .claim("userId", userId) // 嵌入用户ID
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + ttl))
                .signWith(Keys.hmacShaKeyFor(jwtProperties.getSecretKey().getBytes()))
                .compact();
    }


    // 解析令牌获取用户名
    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(jwtProperties.getSecretKey().getBytes()))
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
    public void printTokenInfo(String token) {
        try {
            Claims claims = getClaimsFromToken(token);

            // 1. 输出标准声明（Subject, Expiration, Issued At）
            System.out.println("Subject (用户ID): " + claims.getSubject());
            System.out.println("Expiration (过期时间): " + sdf1.format(claims.getExpiration()));
            System.out.println("Issued At (签发时间): " + sdf1.format(claims.getIssuedAt()));

            // 2. 输出自定义声明（如角色、用户名等）
            System.out.println("---- 自定义声明 ----");
            claims.forEach((key, value) -> {
                if (!key.equals("sub") && !key.equals("exp") && !key.equals("iat")) {
                    System.out.println(key + ": " + value);
                }
            });

        } catch (ExpiredJwtException e) {
            System.err.println("Token 已过期: " + e.getMessage());
        } catch (SignatureException e) {
            System.err.println("签名验证失败: 密钥不匹配或 Token 被篡改");
        } catch (MalformedJwtException e) {
            System.err.println("Token 格式错误: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("解析异常: " + e.getClass().getSimpleName());
        }
    }
    public Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(jwtProperties.getSecretKey().getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // 验证令牌有效性
    public boolean validateToken(String token) {
        try {
            Jwts.parser().verifyWith(Keys.hmacShaKeyFor(jwtProperties.getSecretKey().getBytes())).build().parse(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            log.error("token无效",e);
            return false;
        }
    }
}
