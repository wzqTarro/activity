package com.activity.result;

import com.activity.util.ResultUtil;
import com.alibaba.fastjson.JSONObject;

/**
 * controller对外响应对象
 *                       
 * @Filename ControllerResult.java
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
public class ControllerResult extends ResultUtil{

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -1013360803236786873L;
	private JSONObject data;
	public JSONObject getData() {
		return data;
	}
	public void setData(JSONObject data) {
		this.data = data;
	}
}
