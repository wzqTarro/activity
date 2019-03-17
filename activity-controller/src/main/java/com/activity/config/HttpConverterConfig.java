package com.activity.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
public class HttpConverterConfig {

	/**
	 * 配置fastJSON
	 * <p>
	 * 应用领域：
	 * </p>
	 *
	 * @return
	 * @author wangziqin by 2019年3月2日 下午6:57:42
	 */
	@Bean
	public HttpMessageConverters faseJsonHttpMessageConverters() {
		// 定义一个convert转换消息对象
		FastJsonHttpMessageConverter convert = new FastJsonHttpMessageConverter();
		
		// 添加fastjson配置信息
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		
		// 是否格式化返回json数据，默认不格式化
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		
		convert.setFastJsonConfig(fastJsonConfig);
		
		return new HttpMessageConverters(convert);
	}
}
