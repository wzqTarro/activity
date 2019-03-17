package com.activity.util;

/**
 * 验证工具类
 *                       
 * @Filename ValidateUtil.java
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
 * <li>Date: 2019年2月28日</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 *
 */
public class ValidateUtil {
	
	/**
	 * 判断字符串是否为空
	 * <p>
	 * 应用领域：
	 * </p>
	 *
	 * @param value
	 * @return
	 * @author wangziqin by 2019年2月28日 下午2:25:58
	 */
	public static boolean isEmpty(String value) {
		if (value == null) {
			return true;
		}
		if (value.length() <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断多个字符串是否为空
	 * <p>
	 * 应用领域：
	 * </p>
	 *
	 * @param values
	 * @return
	 * @author wangziqin by 2019年2月28日 下午2:25:03
	 */
	public static boolean isEmpty(String... values) {
		for (String value: values) {
			isEmpty(value);
		}
		return false;
	}
}
