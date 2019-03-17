package com.activity.util;

import java.io.Serializable;

import com.activity.constant.CommonValue;
import com.activity.constant.TipsEnum;


/**
 * 通用响应类
 *                       
 * @Filename ResultUtil.java
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
public class ResultUtil implements Serializable {
	
	private static final long serialVersionUID = 130769520693217001L;

	/**00:成功  99:失败**/
	private String respCode = CommonValue.SUCCESS_CODE;
	
	private String respMsg = CommonValue.SUCCESS_MSG;
	
	public ResultUtil() {}

	public ResultUtil(String respCode) {
		this.respCode = respCode;
	}
	
	public ResultUtil(String respCode, String respMsg) {
		this.respCode = respCode;
		this.respMsg = respMsg;
	}

	public String getRespCode() {
		return respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	
	public void error(String msg) {
		this.respCode = CommonValue.ERROR_CODE;
		this.respMsg = msg;
	}
	
	public void error(String code, String msg) {
		this.respCode = code;
		this.respMsg = msg;
	}
	
	public boolean isSuccess() {
		if (this.respCode.equals(CommonValue.SUCCESS_CODE)) {
			return true;
		}
		return false;
	}
}
