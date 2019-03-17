package com.activity.util;

import java.util.Date;

import com.activity.constant.CommonValue;
import com.activity.thread.CustomThreadLocal;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * JWT工具类
 *                       
 * @Filename JwtUtil.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author wangziqin
 *
 * @Email wangziqin@zcareze.com
 *       
 * @History
 * <li>Author: wangziqin</li>
 * <li>Date: 2019年3月7日</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 *
 */
public class JwtUtil {
	
	/** 账号 **/
	public static final String USER_NAME = "userName";
	/** 角色 **/
	public static final String ROLE = "role";
	
	/** 过期时间 60秒 **/
	private static final int EXPIRE_TIME = 60 * 1000;
	
	/**
	 * 算法
	 * <p>
	 * 应用领域：
	 * </p>
	 *
	 * @return
	 * @author wangziqin by 2019年3月7日 上午11:49:55
	 */
	private static Algorithm algorithm() {
		return Algorithm.HMAC256(CommonValue.JWT_SECRET);
	}
	
	/**
	 * 生成jwt
	 * <p>
	 * 应用领域： 
	 * </p>
	 *
	 * @return
	 * @author wangziqin by 2019年3月7日 上午11:38:26
	 */
	public static String createToken(String userName, String role) {

		//Date now = new Date();
		//Date exp = new Date(now.getTime() + EXPIRE_TIME);
		String token = JWT.create()
				//.withIssuedAt(now) // 签发时间
				//.withNotBefore(now) // 定义在什么时间之前，该jwt不可用
				//.withExpiresAt(exp) // 过期时间
				.withClaim(USER_NAME, userName)
				.withClaim(ROLE, role)
				.sign(algorithm());
		return token;
	}
	
	/**
	 * 验证jwt
	 * <p>
	 * 应用领域：
	 * </p>
	 *
	 * @param token
	 * @return
	 * @author wangziqin by 2019年3月7日 上午11:45:43
	 */
	public static boolean verifyToken(String token) {
		JWTVerifier verifier = JWT.require(algorithm())
				.build();
		try {
			verifier.verify(token);			
		} catch (JWTVerificationException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * 获取值
	 * <p>
	 * 应用领域：
	 * </p>
	 *
	 * @param token
	 * @param key
	 * @return
	 * @author wangziqin by 2019年3月7日 下午12:16:33
	 */
	public static String getValue(String token, String key) {
		JWTVerifier verifier = JWT.require(algorithm())
				.build();
		try {
			DecodedJWT jwt = verifier.verify(token);			

			return jwt.getClaim(key).asString();
		} catch (JWTVerificationException e) {
			return null;
		}
	}
} 
