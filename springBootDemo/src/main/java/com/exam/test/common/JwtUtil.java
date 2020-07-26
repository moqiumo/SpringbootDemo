package com.exam.test.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.exam.test.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;



/**
 * @description: Jwt工具类，生成JWT和认证
 * @author yyy
 */
public class JwtUtil {
    private static final Logger logger= LoggerFactory.getLogger(JwtUtil.class);
    /**
     * 密码
     */
    private static final String SECRET="my_secret";
    /**
     * 过期时间
     */
    private  static final long EXPIRATION=1800L;//单位秒

    /**
     * 生成用户token，并设置token超时时间
     * @param user
     * @return
     */
    public static String createToken(User user){
        Date expireDate=new Date(System.currentTimeMillis()+EXPIRATION*1000)  ;
        Map<String,Object> map=new HashMap<>();
        map.put("alg","HS256");
        map.put("typ","JWT");
        String token= JWT.create()
                .withHeader(map)//添加头部
                //可以将基本信息放到claims中
                .withClaim("id",user.getId())//Id
                .withClaim("username",user.getUserName())//username
                .withClaim("password",user.getPassword())//password
                .withExpiresAt(expireDate)//设置过期日期
                .withIssuedAt(new Date())//签发时间
                .sign(Algorithm.HMAC256(SECRET));//设置私匙信息
        return token;
    }

    /**
     * 校验token并解析token
     * @param token
     * @return
     */
    public static Map<String, Claim> verifyToken(String token){
        DecodedJWT jwt=null;
        try {
            JWTVerifier verifier=JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt=verifier.verify(token);
        } catch (Exception e){
            logger.error(e.getMessage());
            logger.error("token解码异常");
            return  null;
        }
        return jwt.getClaims();
    }


}