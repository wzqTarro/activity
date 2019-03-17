package com.activity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.activity.interceptors.TokenInterceptor;

/**
 * web请求配置类
 *                       
 * @Filename WebConfig.java
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
@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Autowired
	private TokenInterceptor tokenInterceptor;

	/**
	 * 跨域设置
	 * @param registry
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry)
	 * @author wangziqin by 2019年3月7日 上午10:58:03
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedMethods("GET", "POST", "PUT", "DELETE")
			.allowedOrigins("*")
			.maxAge(3600);
	}
	
	/**    
	 * 拦截器
	 * @param registry
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 * @author wangziqin by 2019年3月7日 上午11:28:49
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/*
		 * registry.addInterceptor(tokenInterceptor) .addPathPatterns("/**")
		 * .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**",
		 * "/swagger-ui.html/**");
		 */
	}
}
