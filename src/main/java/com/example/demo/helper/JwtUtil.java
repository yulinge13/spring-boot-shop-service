package com.example.demo.helper;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Component
public class JwtUtil {
    // 过期时间60分钟
    private final long EXPIRE_TIME = 60*60*1000;

    /**
     * 校验token是否正确
     * @param token 密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public boolean verify(String token, Integer getUserId, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("id", getUserId)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    public Integer getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            System.out.println("jwt.getClaim().asInt()"+jwt.getClaim("id").asInt());
            return jwt.getClaim("id").asInt();
        } catch (JWTDecodeException e) {
            System.out.println("JWTDecodeException"+e);
            return null;
        }
    }
    /**
     * 生成签名,60min后过期
     * @param userId 用户名
     * @param secret 用户的密码
     * @return 加密的token
     */
    public String sign(Integer userId, String secret) {
        try {
            Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带username信息
            return JWT.create()
                    .withClaim("id", userId)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

}
