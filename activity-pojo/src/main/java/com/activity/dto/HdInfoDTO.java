package com.activity.dto;

import java.io.Serializable;
import java.util.List;

import com.activity.bean.Datainfo;
import com.activity.bean.Hdinfo;
import com.activity.bean.Signin;
import com.activity.bean.Signup;

public class HdInfoDTO extends Hdinfo implements Serializable{

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 344326084885352870L;

	private List<Datainfo> dataList;
	
	private List<Signin> signinList;
	
	private List<Signup> signupList;

	public List<Signup> getSignupList() {
		return signupList;
	}

	public void setSignupList(List<Signup> signupList) {
		this.signupList = signupList;
	}

	public List<Datainfo> getDataList() {
		return dataList;
	}

	public void setDataList(List<Datainfo> dataList) {
		this.dataList = dataList;
	}

	public List<Signin> getSigninList() {
		return signinList;
	}

	public void setSigninList(List<Signin> signinList) {
		this.signinList = signinList;
	}
}
