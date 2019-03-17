package com.activity.enst;

/**
 * 文件类型
 *                       
 * @Filename DataTypeEnum.java
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
public enum DataTypeEnum {
	
	/** 通知或日程安排=>0 **/
	NOTICE("通知或日程安排", "0"),
	/** word=>1 **/
	WORD("word", "1"),
	/** ppt=>2 **/
	PPT("ppt", "2"),
	/** excel=>3 **/
	EXCEL("excel", "3"),
	/** jpg=>4 **/
	JPG("jpg", "4"),
	/** video=>5 **/
	VIDEO("video", "5"),
	/** music=>6 **/
	MUSIC("music", "6"),
	/** other=>7 **/
	OTHER("other", "7")
	;
	
	private String msg;
	private String code;
	
	private DataTypeEnum(String msg, String code) {
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
