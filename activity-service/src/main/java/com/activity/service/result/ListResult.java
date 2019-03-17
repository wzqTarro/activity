package com.activity.service.result;

import java.util.List;

import com.activity.util.ResultUtil;

/**
 * 列表响应对象
 *                       
 * @Filename ListResult.java
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
public class ListResult<T> extends ResultUtil{

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -1752505988619459247L;
	private List<T> list;
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
