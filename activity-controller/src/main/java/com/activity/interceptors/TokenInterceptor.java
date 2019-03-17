package com.activity.interceptors;

import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.activity.annotation.PassToken;
import com.activity.bean.Userinfo;
import com.activity.constant.CommonValue;
import com.activity.result.ControllerResult;
import com.activity.thread.CustomThreadLocal;
import com.activity.util.JwtUtil;
import com.alibaba.fastjson.JSON;

/**
 * token验证拦截器
 *                       
 * @Filename TokenInterceptor.java
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
@Component
public class TokenInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 如果不是映射到方法，直接跳过
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		
		// 获取方法
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		// 方法有passToken注解
		if (method.isAnnotationPresent(PassToken.class)) {
			PassToken passToken = method.getAnnotation(PassToken.class);
			if (passToken.required()) {
				return true;
			}
		}
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		
		// 签名
		String token = (String) request.getAttribute("token");
		if (!JwtUtil.verifyToken(token)) {
			ControllerResult result = new ControllerResult();
			result.error("签名验证失败");
			return false;
		}
		
		// 判断是否为对应账号签名
		String userName = JwtUtil.getValue(token, JwtUtil.USER_NAME);
		String role = JwtUtil.getValue(token, JwtUtil.ROLE);
		Userinfo userInfo = new Userinfo();
		userInfo.setZh(userName);
		CustomThreadLocal.set(CommonValue.CURRENT_LOGIN_INFO, userInfo);
		
		return true;
	}
}
