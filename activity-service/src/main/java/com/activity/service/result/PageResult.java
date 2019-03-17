package com.activity.service.result;

/**
 * 分页返回对象
 *                       
 * @Filename PageResult.java
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
public class PageResult<T> extends ListResult<T>{

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -1484934125275441591L;
	private Integer count;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
