package com.activity.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MD5工具类
 *                       
 * @Filename Md5Util.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author wangziqin
 *
 * @Email 
 *       
 * @History
 * <li>Author: wangziqin</li>
 * <li>Date: 2019年3月1日</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 *
 */
public class Md5Util {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(Md5Util.class);
	
	/**
	 * 生成md5
	 * <p>
	 * 应用领域：
	 * </p>
	 *
	 * @param msg
	 * @param 密钥
	 * @return
	 * @author wangziqin by 2019年3月1日 下午5:36:27
	 * @throws Exception 
	 */
	public static String generateMd5(String msg, String secret) {
		msg = secret + msg;
		// 定义一个字节数组
		byte[] secretBytes = null;
		
		// 生成MD5加密计算摘要
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			// 对字符串进行加密
			md.update(msg.getBytes());
			// 获取加密后的数据
			secretBytes = md.digest();
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("没有md5这个算法");
			throw new RuntimeException("没有md5这个算法");
		}
		
		// 将加密后的数据转换为16进制数字
		String md5Code = new BigInteger(1, secretBytes).toString(16);
		
		// 如果未满32位， 需要前面补0
		for (int i = 0; i < 32 - md5Code.length(); i++) {
			md5Code = "0" + md5Code;
		}
		return md5Code;
	}
	
	/**
	 * 验证
	 * <p>
	 * 应用领域：
	 * </p>
	 *
	 * @param md5 密文
	 * @param text 明文
	 * @param secret 密钥
	 * @return
	 * @author wangziqin by 2019年3月1日 下午5:48:25
	 */
	public static boolean validate(String md5, String text, String secret) {
		return md5.equalsIgnoreCase(generateMd5(text, secret));
	}
}
