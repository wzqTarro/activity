package com.activity.enst;

/**
 * 活动级别
 *                       
 * @Filename ActivityLevelEnum.java
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
 * <li>Date: 2019年3月2日</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 *
 */
public enum ActivityLevelEnum {
	/** 市级=>2 **/
	CITY("市级", "2"),
	/** 区县级=>3 **/
	COUNTY("区县级", "3"),
	/** 校级=>4 **/
	SCHOOL("校级", "4"),
	;
	
	private String msg;
	private String code;
	
	private ActivityLevelEnum(String msg, String code) {
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public String getCode() {
		return code;
	}
}
