package com.activity.thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;

/**
 * 定制当前线程
 *                       
 * @Filename CustomThreadLocal.java
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
 * <li>Date: 2019年2月27日</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 *
 */
public class CustomThreadLocal {
	
	private static ThreadLocal<Map<String, Object>> CURRENT_THREAD = new ThreadLocal<>();
	
	public static Object get(String key) {
		Map<String, Object> map = CURRENT_THREAD.get();
		if (map == null) {
			map = new ConcurrentHashMap<>(1);
		}
		return map.get(key);
	}
	
	public static void set(String key, Object value) {
		if (StringUtils.isNoneBlank(key) && value != null) {
			Map<String, Object> map = CURRENT_THREAD.get();
			if (map == null) {
				map = new ConcurrentHashMap<>(1);
			}
			map.put(key, value);
			CURRENT_THREAD.set(map);
		}
	}
	
	public static void remove(String key) {
		if (StringUtils.isNoneBlank(key)) {
			Map<String, Object> map = CURRENT_THREAD.get();
			if (map == null) {
				map = new ConcurrentHashMap<>(1);
			}
			map.remove(key);
			CURRENT_THREAD.set(map);
		}
	}
}
