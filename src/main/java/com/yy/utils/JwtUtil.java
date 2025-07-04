package com.yy.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtil {

    private static final String KEY = "itheima";
    private static final long EXPIRE_TIME = 1000 * 60 * 60 * 24; //1天
	
	//接收业务数据,生成token并返回
    public static String genToken(Map<String, Object> claims) {
        return genToken(claims, EXPIRE_TIME);
    }

	//接收token,验证token,并返回业务数据
    public static Map<String, Object> parseToken(String token) {
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
    public static String genToken(Map<String, Object> claims,long expireTime) {
        return JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + expireTime ))
                .sign(Algorithm.HMAC256(KEY));
    }

}
