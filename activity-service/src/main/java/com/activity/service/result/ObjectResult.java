package com.activity.service.result;

import com.activity.util.ResultUtil;

/**
 * 对象返回
 *                       
 * @Filename ObjectResult.java
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
public class ObjectResult<T> extends ResultUtil {
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 7506721741262851846L;
	private T data;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
